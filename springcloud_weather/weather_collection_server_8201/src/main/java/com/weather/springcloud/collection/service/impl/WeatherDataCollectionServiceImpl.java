package com.weather.springcloud.collection.service.impl;

import java.util.concurrent.TimeUnit;

import com.weather.springcloud.api.model.entities.city.City;
import com.weather.springcloud.api.service.CityClient;
import com.weather.springcloud.collection.service.WeatherDataCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 14:50
 * 天气数据获取服务接口实现
 */
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

	private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

	private static final long TIME_OUT = 1800L; // 1800s
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private CityClient cityClient;
	
	@Override
	public void syncDateByCityId(City city) throws Exception{
		this.saveWeatherData(city);
	}
	
	/**
	 * 把天气数据放在缓存
	 * @param city
	 */
	private void saveWeatherData(City city) throws Exception{
		String url = WEATHER_URI + "citykey=" + city.getCityId();
		ValueOperations<String, String>  ops = stringRedisTemplate.opsForValue();

		// 调用服务接口来获取
 		ResponseEntity<String> respString = restTemplate.getForEntity(url, String.class);

 		if (respString.getStatusCodeValue() == 200) {
			city.setWeatherData(respString.getBody());
			// 数据写入缓存
			ops.set(city.getCityId(), city.getWeatherData(), TIME_OUT, TimeUnit.SECONDS);
			// 写入数据库
			cityClient.updateCity(city);
		}
	}
}
