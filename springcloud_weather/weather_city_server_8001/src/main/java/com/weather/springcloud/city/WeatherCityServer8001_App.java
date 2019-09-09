package com.weather.springcloud.city;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 13:52
 */
@SpringBootApplication
@MapperScan({"com.weather.springcloud.city.dao"})  //自动扫描mybatis生成的mapper接口
@EnableEurekaClient   //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient //服务发现
//开启Hystrix，该注解包含了@EnableCircuitBreaker(对Hystrix熔断机制的支持，@HystrixCommand 熔断处理，可单独使用)，在使用HystrixDashboard实现监控时必须开启两个注解之一
@EnableHystrix
public class WeatherCityServer8001_App {

    public static void main(String[] args) {
        SpringApplication.run(WeatherCityServer8001_App.class,args);
    }
}
