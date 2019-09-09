package com.weather.springcloud.report.service;


import com.weather.springcloud.api.model.entities.weather.Weather;

/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 14:00
 */
public interface WeatherReportService {

	/**
	 * 根据城市ID查询天气信息
	 * @param cityId
	 * @return
	 */
	Weather getDataByCityId(String cityId) throws Exception;
}
