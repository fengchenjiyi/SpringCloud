package com.weather.springcloud.controller;

import com.weather.springcloud.api.model.beans.ResponseMsgBody;
import com.weather.springcloud.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 14:36
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/cityId/{cityId}")
    public ResponseMsgBody getWeatherByCityId(@PathVariable("cityId") String cityId) throws Exception {
        return ResponseMsgBody.success().add("cityIdData",weatherDataService.getDataByCityId(cityId));
    }

    @GetMapping("/cityName/{cityName}")
    public ResponseMsgBody getWeatherByCityName(@PathVariable("cityName") String cityName) throws Exception {
        return ResponseMsgBody.success().add("cityNameData",weatherDataService.getDataByCityName(cityName));
    }
}
