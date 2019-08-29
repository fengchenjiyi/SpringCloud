package com.gogoo.springcloud.controller;

import java.util.List;

import com.gogoo.springcloud.beans.MsgExtend;
import com.gogoo.springcloud.entities.Dept;
import com.gogoo.springcloud.service.DeptService;
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

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public ResponseEntity<MsgExtend> add(@RequestBody Dept dept)
	{
		boolean rs = service.add(dept);
		if(rs){
			return ResponseEntity.ok().body(MsgExtend.success());
		}
		return ResponseEntity.ok().body(MsgExtend.fail());
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<MsgExtend> get(@PathVariable("id") Long id)
	{
		Dept dept = service.get(id);
		return ResponseEntity.ok().body(MsgExtend.success().add("dept",dept));
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public ResponseEntity<MsgExtend> list()
	{
		List<Dept> deptList = service.list();
		return ResponseEntity.ok().body(MsgExtend.success().add("deptList",deptList));
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
