package com.yaoln.zuulgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/19 10:23
 * zuul是集成Ribbon自动负载均衡
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient  //服务发现
public class ZuulGateway_App {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGateway_App.class,args);
    }

}
