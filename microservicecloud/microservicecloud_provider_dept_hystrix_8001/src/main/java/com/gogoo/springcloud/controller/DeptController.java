package com.gogoo.springcloud.controller;

import java.util.List;

import com.gogoo.springcloud.beans.MsgExtend;
import com.gogoo.springcloud.entities.Dept;
import com.gogoo.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeptController
{
	@Autowired
	private DeptService service;

	/* 服务发现客户端 */
	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	//一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
	@HystrixCommand(fallbackMethod = "processHystrix_Get")  //熔断处理
	public ResponseEntity<MsgExtend> get(@PathVariable("id") Long id)
	{
		Dept dept = service.get(id);
		if(dept == null){
			throw new RuntimeException();
		}
		return ResponseEntity.ok().body(MsgExtend.success().add("dept",dept));
	}

	public ResponseEntity<MsgExtend> processHystrix_Get(@PathVariable("id") Long id)
	{
		return ResponseEntity.ok().body(MsgExtend.fail().addErr("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand"));
	}


	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery()
	{
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}

}
