package com.gogoo.springcloud;

import com.gogoo.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Created by 290879584 on 2019/8/26.
 */
@SpringBootApplication
@EnableEurekaClient   //整合Ribbon需要Eureka客户端
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelfRule.class)  //在启动该微服务的时候加载我们的自定义Ribbon配置类，从而使配置生效
public class DeptConsumer80_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class,args);
    }
}
