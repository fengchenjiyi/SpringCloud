package com.weather.springcloud.city.service;



import com.weather.springcloud.api.model.entities.city.City;

import java.util.List;

/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 13:52
 */
public interface CityDataService {

	/**
	 * 获取City列表
	 * @return
	 * @throws Exception
	 */
	List<City> listCity() throws Exception;

	/**
	 * 修改城市数据
	 * @param city
	 * @throws Exception
	 */
	int updateCity(City city) throws Exception;

	/**
	 * 根据城市id查询天气数据
	 * @param cityId
	 * @return
	 * @throws Exception
	 */
	City selectByCityId(String cityId) throws Exception;

	/**
	 * 根据城市名称查询天气数据
	 * @param cityName
	 * @return
	 * @throws Exception
	 */
	City selectByCityName(String cityName) throws Exception;
}
