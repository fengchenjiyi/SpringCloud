package com.weather.springcloud.hystrixdt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


/**
 * @Auther: F~cjy
 * @Date: 2019/9/4 00:02
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardTurbine9201_App {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardTurbine9201_App.class,args);
    }
}
