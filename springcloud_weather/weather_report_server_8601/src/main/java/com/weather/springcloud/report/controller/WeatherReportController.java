package com.weather.springcloud.report.controller;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.weather.springcloud.api.model.beans.ResponseMsgBody;
import com.weather.springcloud.api.model.entities.city.City;
import com.weather.springcloud.api.service.CityClient;
import com.weather.springcloud.api.utils.JacksonUtils;
import com.weather.springcloud.report.service.WeatherReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.List;


/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 14:36
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {

	private final static Logger logger = LoggerFactory.getLogger(WeatherReportController.class);
	@Value("${server.port}")
	private String port;

	@Autowired
	private WeatherReportService weatherReportService;
	@Autowired
	private CityClient cityClient;

	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
		mv.setViewName("forward:/report/cityId/101280101");
		return mv;
	}
	
	@GetMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
		logger.error("服务端口==" + port);

		// 获取城市ID列表
		List<City> cityList = null;
		ResponseMsgBody rmb = cityClient.listCity();
		if(rmb.getCode() == ResponseMsgBody.SUCCESS_CODE){
			//json转List<City>
			JavaType jt = JacksonUtils.getJackson().getTypeFactory().constructParametricType(ArrayList.class, City.class);
			cityList = JacksonUtils.getJackson().readValue(rmb.getDataJson(),jt);
		}

		model.addAttribute("title", "F~cjy的天气预报");
		model.addAttribute("cityId", cityId);
		model.addAttribute("cityList", cityList);
		model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
		return new ModelAndView("weather/report", "reportModel", model);
	}

}
