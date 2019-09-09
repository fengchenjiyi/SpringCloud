package com.weather.springcloud.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 13:52
 */
@SpringBootApplication
@EnableEurekaClient   //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient //服务发现
//开启Hystrix，该注解包含了@EnableCircuitBreaker(对Hystrix熔断机制的支持，@HystrixCommand 熔断处理，可单独使用)，在使用HystrixDashboard实现监控时必须开启两个注解之一
@EnableHystrix
@EnableFeignClients(basePackages= {"com.weather.springcloud.api.service"})   // 启动Feign，由于带@FeignClient的接口在api包，这里进行扫描
//对相关包下组件进行扫描，设置两个，第一个是对项目本身组件进行扫描，不然会出现controller无法访问，第二是对api.service包下组件扫描，否则会出现服务降级组件加载失败
@ComponentScan(basePackages = {"com.weather.springcloud.report","com.weather.springcloud.api.service"})
public class WeatherReportServer8601_App {

    public static void main(String[] args) {
        SpringApplication.run(WeatherReportServer8601_App.class,args);
    }
}
