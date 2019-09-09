package com.weather.springcloud.collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 13:52
 */
@SpringBootApplication
@EnableEurekaClient   //本服务启动后会自动注册进eureka服务中, 有下面注解该注解可以忽略
@EnableDiscoveryClient //服务发现
@EnableFeignClients(basePackages= {"com.weather.springcloud.api.service"})   // 启动Feign，由于带@FeignClient的接口在api包，这里进行扫描
//对相关包下组件进行扫描，设置两个，第一个是对项目本身组件进行扫描，不然会出现controller无法访问，第二是对api.service包下组件扫描，否则会出现服务降级组件加载失败
@ComponentScan(basePackages = {"com.weather.springcloud.collection","com.weather.springcloud.api.service"})
public class WeatherCollectionServer8201_App {

    public static void main(String[] args) {
        SpringApplication.run(WeatherCollectionServer8201_App.class,args);
    }
}
