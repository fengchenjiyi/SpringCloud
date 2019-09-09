package com.weather.springcloud.controller;

import com.weather.springcloud.service.CityDataService;
import com.weather.springcloud.service.WeatherReportService;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 14:36
 */
@RestController
public class WeatherReportController {
	@Autowired
	private CityDataService cityDataService;
	
	@Autowired
	private WeatherReportService weatherReportService;

	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
		mv.setViewName("forward:/report/cityId/101280101");
		return mv;
	}
	
	@GetMapping("/report/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
		model.addAttribute("title", "天气预报");
		model.addAttribute("cityId", cityId);
		model.addAttribute("cityList", cityDataService.listCity());
		model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
		return new ModelAndView("weather/report", "reportModel", model);
	}

}
