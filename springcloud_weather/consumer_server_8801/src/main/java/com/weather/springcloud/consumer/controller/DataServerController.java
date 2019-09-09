package com.weather.springcloud.consumer.controller;

import com.weather.springcloud.api.model.beans.ResponseMsgBody;
import com.weather.springcloud.api.service.WeatherDataClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: F~cjy
 * @Date: 2019/9/6 15:43
 */
@RestController
@RequestMapping("/weather")
public class DataServerController {

    @Autowired
    private WeatherDataClient dataClient;

    @GetMapping("/cityId/{cityId}")
    public ResponseMsgBody getWeatherByCityId(@PathVariable("cityId") String cityId) throws Exception {
        return dataClient.getWeatherByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public ResponseMsgBody getWeatherByCityName(@PathVariable("cityName") String cityName) throws Exception {
        return dataClient.getWeatherByCityName(cityName);
    }
}
