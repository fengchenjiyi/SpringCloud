package com.yaoln.hystrixdt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/21 00:04
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardTurbine_App {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardTurbine_App.class,args);
    }

}
