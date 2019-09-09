package com.weather.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 13:52
 * 天气预报单一完整demo，与微服务无关
 */
@SpringBootApplication
public class WeatherDemo8080_App {

    public static void main(String[] args) {
        SpringApplication.run(WeatherDemo8080_App.class,args);
    }
}
