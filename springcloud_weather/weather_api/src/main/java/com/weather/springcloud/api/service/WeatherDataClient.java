package com.weather.springcloud.api.service;

import com.weather.springcloud.api.model.beans.ResponseMsgBody;
import com.weather.springcloud.api.model.entities.weather.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 天气数据微服务客户端
 * @Auther: F~cjy
 * @Date: 2019/9/2 11:30
 */
@FeignClient(name = "WEATHER-DATA-SERVER", fallback = WeatherDataClientFallback.class)
public interface WeatherDataClient {

    @GetMapping("/weather/cityId/{cityId}")
    ResponseMsgBody getWeatherByCityId(@PathVariable("cityId") String cityId);

    @GetMapping("/weather/cityName/{cityName}")
    ResponseMsgBody getWeatherByCityName(@PathVariable("cityName") String cityName);
}
