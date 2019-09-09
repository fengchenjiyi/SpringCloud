package com.weather.springcloud.consumer.controller;

import com.weather.springcloud.api.model.beans.ResponseMsgBody;
import com.weather.springcloud.api.service.CityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: F~cjy
 * @Date: 2019/9/6 16:02
 */
@RestController
@RequestMapping("/city")
public class CityServerController {

    @Autowired
    private CityClient cityClient;

    @GetMapping("/list")
    public ResponseMsgBody listCity() throws Exception {
        return cityClient.listCity();
    }
}
