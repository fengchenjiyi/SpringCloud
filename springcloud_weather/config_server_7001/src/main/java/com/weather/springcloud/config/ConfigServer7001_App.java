package com.weather.springcloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Auther: F~cjy
 * @Date: 2019/9/5 21:24
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer7001_App {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer7001_App.class,args);
    }
}
