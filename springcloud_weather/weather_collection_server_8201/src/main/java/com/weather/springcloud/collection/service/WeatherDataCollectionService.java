package com.weather.springcloud.collection.service;

import com.weather.springcloud.api.model.entities.city.City;

/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 14:50
 * 天气数据获取服务接口
 */
public interface WeatherDataCollectionService {

	/**
	 * 根据城市ID同步天气
	 * @param city
	 */
	void syncDateByCityId(City city) throws Exception;
}
