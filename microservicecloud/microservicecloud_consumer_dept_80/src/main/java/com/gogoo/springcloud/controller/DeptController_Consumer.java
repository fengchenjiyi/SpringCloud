package com.gogoo.springcloud.controller;

import com.gogoo.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 290879584 on 2019/8/26.
 */
@RestController
public class DeptController_Consumer {

    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";  //微服务名称

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/consumer/dept/add")
    public String add(Dept dept)
    {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, String.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public String get(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, String.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/consumer/dept/list")
    public String list()
    {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", String.class);
    }

    // 测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery()
    {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }
}
