package com.weather.springcloud.data.service;

import com.weather.springcloud.api.model.entities.weather.WeatherResponse;

/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 13:54
 */
public interface WeatherDataService {

    /**
     * 根据城市ID查询天气数据
     *
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId) throws Exception;

    /**
     * 根据城市名称查询天气数据
     *
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName) throws Exception;
}
