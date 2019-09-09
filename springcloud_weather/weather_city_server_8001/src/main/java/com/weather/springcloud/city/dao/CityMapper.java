package com.weather.springcloud.city.dao;


import com.weather.springcloud.api.model.entities.city.City;
import com.weather.springcloud.city.utils.MyMapper;

import java.util.List;

public interface CityMapper extends MyMapper<City> {

    List<City>  selectCityList();
}