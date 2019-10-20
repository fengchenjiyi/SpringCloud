package com.yaoln.usercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/16 12:18
 */
@SpringBootApplication
@EnableEurekaClient   //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient //服务发现
//开启Hystrix，该注解包含了@EnableCircuitBreaker(对Hystrix熔断机制的支持，@HystrixCommand 熔断处理，可单独使用)，在使用HystrixDashboard实现监控时必须开启两个注解之一
@EnableHystrix
public class UserCenter_App {

    public static void main(String[] args) {
        SpringApplication.run(UserCenter_App.class,args);
    }

}
