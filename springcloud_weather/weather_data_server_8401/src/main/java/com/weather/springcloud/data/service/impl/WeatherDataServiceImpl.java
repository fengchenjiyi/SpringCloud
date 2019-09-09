package com.weather.springcloud.data.service.impl;

import com.weather.springcloud.api.model.beans.ResponseMsgBody;
import com.weather.springcloud.api.model.entities.city.City;
import com.weather.springcloud.api.model.entities.weather.WeatherResponse;
import com.weather.springcloud.api.service.CityClient;
import com.weather.springcloud.api.utils.JacksonUtils;
import com.weather.springcloud.data.service.WeatherDataService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 14:00
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private CityClient cityClient;

    @Override
    public WeatherResponse getDataByCityId(String cityId) throws Exception {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String strBody = null;
        if(stringRedisTemplate.hasKey(cityId)){
            strBody = ops.get(cityId);
        }else {
            ResponseMsgBody rmb = cityClient.selectByCityId(cityId);
            if(rmb.getCode() == ResponseMsgBody.SUCCESS_CODE){
                City city = JacksonUtils.getJackson().readValue(rmb.getDataJson(),City.class);
                strBody = city.getWeatherData();
            }
        }
        return doGetWeahter(strBody);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) throws Exception {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String strBody = null;
        if(stringRedisTemplate.hasKey(cityName)){
            strBody = ops.get(cityName);
        }else {
            ResponseMsgBody rmb = cityClient.selectByCityName(cityName);
            if(rmb.getCode() == ResponseMsgBody.SUCCESS_CODE){
                City city = JacksonUtils.getJackson().readValue(rmb.getDataJson(),City.class);
                strBody = city.getWeatherData();
            }
        }
        return doGetWeahter(strBody);
    }

    private WeatherResponse doGetWeahter(String strBody) throws Exception {
        WeatherResponse resp = null;
        if(StringUtils.isNotBlank(strBody)){
            try {
                resp = JacksonUtils.getJackson().readValue(strBody, WeatherResponse.class);
            } catch (Exception e) {
                logger.error("天气数据解析异常",e);
            }
        }
        return resp;
    }
}
