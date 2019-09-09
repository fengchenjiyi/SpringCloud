package com.weather.springcloud.api.service;

import com.weather.springcloud.api.model.beans.ResponseMsgBody;
import com.weather.springcloud.api.model.entities.weather.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 天气数据微服务客户端
 * @Auther: F~cjy
 * @Date: 2019/9/2 11:30
 */
@Component // 不要忘记添加，不要忘记添加
public class WeatherDataClientFallback implements WeatherDataClient{


    @Override
    public ResponseMsgBody getWeatherByCityId(String cityId) {
        return ResponseMsgBody.fail().addErr("服务无响应");
    }

    @Override
    public ResponseMsgBody getWeatherByCityName(String cityName) {
        return ResponseMsgBody.fail().addErr("服务无响应");
    }
}
