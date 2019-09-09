package com.weather.springcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 14:50
 */
@Configuration
public class RestConfiguration {

    /**
     * 在使用 RestTemplate 时候请导入Httpclient该依赖，功能更强大
     */
    @Autowired
    private RestTemplateBuilder builder;

    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }
}
