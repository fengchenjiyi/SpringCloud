package com.weather.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Auther: F~cjy
 * @Date: 2019/9/3 22:14
 * zuul是集成Ribbon自动负载均衡
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
public class ZuulGatewayServer9001_App {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayServer9001_App.class,args);
    }
}
