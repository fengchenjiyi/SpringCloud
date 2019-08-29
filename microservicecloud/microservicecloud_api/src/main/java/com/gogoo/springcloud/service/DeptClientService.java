package com.gogoo.springcloud.service;

import com.gogoo.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 290879584 on 2019/8/27.
 * 使用Feign实现面向接口编程
 */
//@FeignClient(value = "MICROSERVICECLOUD-DEPT")   //调用的微服务名称
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService
{
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") long id);

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public String list();

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public String add(Dept dept);

    @RequestMapping(value = "/dept/discovery")
    public Object discovery();
}
