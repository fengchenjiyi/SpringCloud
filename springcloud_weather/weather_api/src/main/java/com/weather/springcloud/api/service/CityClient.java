package com.weather.springcloud.api.service;


import com.weather.springcloud.api.model.beans.ResponseMsgBody;
import com.weather.springcloud.api.model.entities.city.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 城市数据微服务客户端，放在api包方便供其它微服务调用
 * @Auther: F~cjy
 * @Date: 2019/9/1 22:51
 * 注意： 微服务的名字千万不能有下划线
 */
@FeignClient(name = "WEATHER-CITY-SERVER", fallbackFactory = CityClientFallbackFactory.class)
public interface CityClient {

    @GetMapping("/city/list")
    ResponseMsgBody listCity();

    @PostMapping("/city/update")
    ResponseMsgBody updateCity(City city);

    @GetMapping("/city/cityId/{cityId}")
    ResponseMsgBody selectByCityId(@PathVariable("cityId") String cityId);

    @GetMapping("/city/cityName/{cityName}")
    ResponseMsgBody selectByCityName(@PathVariable("cityName") String cityName);

    @GetMapping("/city/discovery")
    ResponseMsgBody discovery();
}
