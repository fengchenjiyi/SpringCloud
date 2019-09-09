package com.weather.springcloud.api.service;

import com.weather.springcloud.api.model.beans.ResponseMsgBody;
import com.weather.springcloud.api.model.entities.city.City;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: F~cjy
 * @Date: 2019/9/3 00:35
 */
@Component // 不要忘记添加，不要忘记添加
public class CityClientFallbackFactory implements FallbackFactory<CityClient> {

    private ResponseMsgBody msgBody = ResponseMsgBody.fail().addErr("服务无响应");

    @Override
    public CityClient create(Throwable throwable) {
        return new CityClient() {
            @Override
            public ResponseMsgBody listCity() {
                City city = new City();
                city.setCityId("101280101");
                city.setCityName("广州");
                city.setCityCode("guangzhou");
                city.setProvince("广东");
                List<City> cityList = new ArrayList<>();
                cityList.add(city);
                return ResponseMsgBody.success().addDataJson(cityList);
            }

            @Override
            public ResponseMsgBody updateCity(City city) {
                return msgBody;
            }

            @Override
            public ResponseMsgBody selectByCityId(String cityId) {
                return msgBody;
            }

            @Override
            public ResponseMsgBody selectByCityName(String cityName) {
                return msgBody;
            }

            @Override
            public ResponseMsgBody discovery() {
                return msgBody;
            }
        };
    }
}
