package com.weather.springcloud.service.impl;

import com.weather.springcloud.api.model.entities.weather.Weather;
import com.weather.springcloud.api.model.entities.weather.WeatherResponse;
import com.weather.springcloud.service.WeatherDataService;
import com.weather.springcloud.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 14:00
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
	@Autowired
	private WeatherDataService weatherDataService;
	
	@Override
	public Weather getDataByCityId(String cityId) throws Exception{
		WeatherResponse resp = weatherDataService.getDataByCityId(cityId);
		return resp.getData();
	}

}
