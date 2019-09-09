package com.weather.springcloud.collection.job;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.springcloud.api.model.beans.ResponseMsgBody;
import com.weather.springcloud.api.model.entities.city.City;
import com.weather.springcloud.api.service.CityClient;
import com.weather.springcloud.api.utils.JacksonUtils;
import com.weather.springcloud.collection.service.WeatherDataCollectionService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 14:00
 * 定时任务同步天气数据
 */
public class WeatherDataSyncJob extends QuartzJobBean {
	
	private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);
	
	@Autowired
	private WeatherDataCollectionService weatherDataCollectionService;

	@Autowired
	private CityClient cityClient;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("开始同步天气数据");

		// 获取城市ID列表
		ResponseMsgBody rmb = cityClient.listCity();
		if(rmb.getCode() == ResponseMsgBody.SUCCESS_CODE){
			try {
				//json转List<City>
				JavaType jt = JacksonUtils.getJackson().getTypeFactory().constructParametricType(List.class, City.class);
				List<City> cityList = JacksonUtils.getJackson().readValue(rmb.getDataJson(),jt);

				// 遍历城市ID获取天气
				for (City city : cityList) {
					logger.info("城市ID:" + city.getCityId());
					try {
						weatherDataCollectionService.syncDateByCityId(city);
					} catch (Exception e) {
						logger.error(city.getCityName() + "的天气数据获取失败",e);
					}
				}
			} catch (Exception e) {
				logger.error("获取城市列表异常",e);
			}
		}

		logger.info("同步天气数据结束");
	}
}
