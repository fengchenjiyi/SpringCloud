package com.weather.springcloud.report.service.impl;

import com.weather.springcloud.api.model.beans.ResponseMsgBody;
import com.weather.springcloud.api.model.entities.weather.Weather;
import com.weather.springcloud.api.model.entities.weather.WeatherResponse;
import com.weather.springcloud.api.service.WeatherDataClient;
import com.weather.springcloud.api.utils.JacksonUtils;
import com.weather.springcloud.report.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 14:00
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

	@Autowired
	private WeatherDataClient weatherDataClient;

	@Override
	public Weather getDataByCityId(String cityId) throws Exception{
		WeatherResponse wr = null;
		ResponseMsgBody rmb = weatherDataClient.getWeatherByCityId(cityId);
		if(rmb.getCode() == ResponseMsgBody.SUCCESS_CODE){
			wr = JacksonUtils.getJackson().readValue(rmb.getDataJson(),WeatherResponse.class);
		}
		return wr == null ? null : wr.getData();
	}
}
