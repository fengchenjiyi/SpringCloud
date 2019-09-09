package com.weather.springcloud.city.service.impl;

import com.weather.springcloud.api.model.entities.city.City;
import com.weather.springcloud.city.dao.CityMapper;
import com.weather.springcloud.city.service.CityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 13:52
 */
@Service
public class CityDataServiceImpl implements CityDataService {

	@Autowired
	private CityMapper cityMapper;

	@Override
	public List<City> listCity() throws Exception {
		return cityMapper.selectCityList();
	}

	@Override
	public int updateCity(City city) throws Exception {
		return cityMapper.updateByPrimaryKeySelective(city);
	}

	@Override
	public City selectByCityId(String cityId) throws Exception {
		Example example = new Example(City.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("cityId",cityId);
		return cityMapper.selectOneByExample(example);
	}

	@Override
	public City selectByCityName(String cityName) throws Exception {
		Example example = new Example(City.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("cityName",cityName);
		return cityMapper.selectOneByExample(example);
	}

}
