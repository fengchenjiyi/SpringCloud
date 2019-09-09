package com.weather.springcloud.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @Auther: F~cjy
 * @Date: 2019/9/5 16:55
 */
@SpringBootApplication
@EnableTurbine     //Turbine断路器聚合监控
public class TurbineServer9401_App {

    public static void main(String[] args) {
        SpringApplication.run(TurbineServer9401_App.class,args);
    }
}
