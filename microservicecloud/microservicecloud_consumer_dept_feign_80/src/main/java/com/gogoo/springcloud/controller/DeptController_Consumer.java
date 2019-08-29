package com.gogoo.springcloud.controller;

import com.gogoo.springcloud.entities.Dept;
import com.gogoo.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 290879584 on 2019/8/26.
 * 面向Feign接口调用编程，Feign集成了Ribbon负载均衡，默认轮询机制
 */
@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService service;

    @RequestMapping(value = "/consumer/dept/add")
    public String add(Dept dept)
    {
        return service.add(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public String get(@PathVariable("id") Long id)
    {
        return service.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public String list()
    {
        return service.list();
    }

    // 测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery()
    {
        return service.discovery();
    }
}
