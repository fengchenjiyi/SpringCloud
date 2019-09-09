package com.weather.springcloud.config;


import com.weather.springcloud.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 14:50
 */
@Configuration
public class QuartzConfiguration {

	private static final int TIME = 1800; // 更新频率

	// JobDetail
	@Bean
	public JobDetail weatherDataSyncJobDetail() {
		return JobBuilder.newJob(WeatherDataSyncJob.class) //WeatherDataSyncJob我们的业务类
				.withIdentity("weatherDataSyncJob")  //可以给该JobDetail起一个id
				.storeDurably()  //即使没有Trigger关联时，也不需要删除该JobDetail
				.build();
	}
	
	// Trigger
	@Bean
	public SimpleTrigger weatherDataSyncTrigger() {

		//定时时间
		SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(TIME).repeatForever();
		
		return TriggerBuilder.newTrigger()
				.forJob(weatherDataSyncJobDetail())  //关联上述的JobDetail
				.withIdentity("weatherDataSyncTrigger")  //给Trigger起个名字
				.withSchedule(schedBuilder)
				.build();
	}
}
