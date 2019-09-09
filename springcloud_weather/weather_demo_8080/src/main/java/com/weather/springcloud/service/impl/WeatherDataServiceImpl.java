package com.weather.springcloud.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.springcloud.api.exception.CustomException;
import com.weather.springcloud.api.model.entities.weather.WeatherResponse;
import com.weather.springcloud.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 14:00
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private static final long TIME_OUT = 1800L;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    
    @Value("${weather_base_url}")
    private String WEATHER_BASE_URL;

    @Override
    public WeatherResponse getDataByCityId(String cityId) throws Exception {
        String url = WEATHER_BASE_URL + "citykey=" + cityId;
        return doGetWeahter(url);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) throws Exception {
        String url = WEATHER_BASE_URL + "dataserver=" + cityName;
        return doGetWeahter(url);
    }

    private WeatherResponse doGetWeahter(String url) throws CustomException {

        WeatherResponse resp = null;
        String strBody = null;

        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        if(stringRedisTemplate.hasKey(url)){
            strBody = ops.get(url);
        }else {
            ResponseEntity<String> respString = restTemplate.getForEntity(url, String.class);

            if(respString.getStatusCodeValue() == 200){
                strBody = respString.getBody();
                // 数据写入缓存，缓存时间1800s
                ops.set(url, strBody, TIME_OUT, TimeUnit.SECONDS);
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            resp = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            throw new CustomException("天气数据解析异常",e);
        }

        return resp;
    }

    @Override
    public void syncDateByCityId(String cityId) {
        String uri = WEATHER_BASE_URL + "citykey=" + cityId;
        this.saveWeatherData(uri);
    }

    /**
     * 把天气数据放在缓存
     * @param url
     */
    private void saveWeatherData(String url) {
        String strBody = null;
        ValueOperations<String, String>  ops = stringRedisTemplate.opsForValue();

        //数据存在就返回，方便调试不断重启
        if(stringRedisTemplate.hasKey(url)){
            return;
        }

        // 调用服务接口来获取
        ResponseEntity<String> respString = restTemplate.getForEntity(url, String.class);

        if (respString.getStatusCodeValue() == 200) {
            strBody = respString.getBody();
            // 数据写入缓存
            ops.set(url, strBody, TIME_OUT, TimeUnit.SECONDS);
        }
    }
}
