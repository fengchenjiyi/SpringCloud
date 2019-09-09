package com.weather.springcloud.service;

import com.weather.springcloud.model.bean.City;
import java.util.List;

/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 14:26
 */
public interface CityDataService {

	/**
	 * 获取City列表
	 * @return
	 * @throws Exception
	 */
	List<City> listCity() throws Exception;
}
