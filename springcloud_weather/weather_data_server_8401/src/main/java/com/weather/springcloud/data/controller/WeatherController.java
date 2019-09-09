package com.weather.springcloud.data.controller;

import com.weather.springcloud.api.model.beans.ResponseMsgBody;
import com.weather.springcloud.api.model.entities.weather.WeatherResponse;
import com.weather.springcloud.data.service.WeatherDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 14:36
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final static Logger logger = LoggerFactory.getLogger(WeatherController.class);
    @Value("${server.port}")
    private String port;

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/cityId/{cityId}")
    public ResponseMsgBody getWeatherByCityId(@PathVariable("cityId") String cityId) throws Exception {
        logger.error("服务端口==" + port);
        WeatherResponse weatherResponse = weatherDataService.getDataByCityId(cityId);
        if(weatherResponse == null){
            return ResponseMsgBody.fail().addErr(cityId + "没有对应天气数据");
        }
        return ResponseMsgBody.success().addDataJson(weatherResponse);
    }

    @GetMapping("/cityName/{cityName}")
    public ResponseMsgBody getWeatherByCityName(@PathVariable("cityName") String cityName) throws Exception {
        logger.error("服务端口==" + port);
        WeatherResponse weatherResponse = weatherDataService.getDataByCityName(cityName);
        if(weatherResponse == null){
            return ResponseMsgBody.fail().addErr(cityName + "没有对应天气数据");
        }
        return ResponseMsgBody.success().addDataJson(weatherResponse);
    }
}
