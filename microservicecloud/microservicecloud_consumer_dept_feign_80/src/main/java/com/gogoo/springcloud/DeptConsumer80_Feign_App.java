package com.gogoo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by 290879584 on 2019/8/26.
 */
@SpringBootApplication
@EnableEurekaClient   //整合Ribbon需要Eureka客户端
@EnableFeignClients(basePackages= {"com.gogoo.springcloud"})
@ComponentScan("com.gogoo.springcloud")
public class DeptConsumer80_Feign_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_Feign_App.class,args);
    }
}
