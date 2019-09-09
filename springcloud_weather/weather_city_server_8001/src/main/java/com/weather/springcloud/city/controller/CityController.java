package com.weather.springcloud.city.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.weather.springcloud.api.model.beans.ResponseMsgBody;
import com.weather.springcloud.api.model.entities.city.City;
import com.weather.springcloud.city.service.CityDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 13:52
 */
@RestController
@RequestMapping("/city")
public class CityController {

	private final static Logger logger = LoggerFactory.getLogger(CityController.class);

	@Value("${server.port}")
	private String port;

	@Autowired
	private CityDataService cityDataService;

	/* 服务发现客户端 */
	@Autowired
	private DiscoveryClient client;
	
	@GetMapping("/list")
	public ResponseMsgBody listCity() throws Exception {
		logger.error("listCity服务端口==" + port);
		List<City> cityList = cityDataService.listCity();
		if(cityList == null && cityList.isEmpty()){
			return ResponseMsgBody.fail().addErr("未查询到任何数据");
		}
		return ResponseMsgBody.success().addDataJson(cityList);
	}

	@PostMapping("/update")
	public ResponseMsgBody updateCity(@RequestBody City city) throws Exception {
		logger.error("updateCity服务端口==" + port);
		int rs = cityDataService.updateCity(city);
		if(rs == 0){
			return ResponseMsgBody.fail().addErr("更新数据失败");
		}
		return ResponseMsgBody.success().addDataJson(rs);
	}

	@GetMapping("/cityId/{cityId}")
	@HystrixCommand     //需要被HystrixDashboard监控到的接口必须有该注解才行，Feign中集成了Hystrix，开启了熔断处理开关后即可被监听到
	public ResponseMsgBody selectByCityId(@PathVariable("cityId") String cityId)throws Exception{
		logger.error("selectByCityId服务端口==" + port);
		City city = cityDataService.selectByCityId(cityId);
		if(city == null){
			return ResponseMsgBody.fail().addErr(cityId + "没有对应数据");
		}
		return ResponseMsgBody.success().addDataJson(city);
	}

	@GetMapping("/cityName/{cityName}")
	@HystrixCommand
	public ResponseMsgBody selectByCityName(@PathVariable("cityName") String cityName)throws Exception{
		logger.error("selectByCityName服务端口==" + port);
		City city = cityDataService.selectByCityName(cityName);
		if(city == null){
			return ResponseMsgBody.fail().addErr(cityName + "没有对应数据");
		}
		return ResponseMsgBody.success().addDataJson(city);
	}

	@RequestMapping(value = "/discovery", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "processHystrix_Discovery")  //熔断处理
	public Object discovery() {
		logger.error("服务端口==" + port);
		List<String> list = client.getServices();
		logger.info("**********" + list);

		List<ServiceInstance> srvList = client.getInstances("WEATHER-CITY-SERVER");
		for (ServiceInstance element : srvList) {
			logger.info(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}

	public ResponseMsgBody processHystrix_Discovery(){
		return ResponseMsgBody.fail().addErr("服务已停止");
	}
}
