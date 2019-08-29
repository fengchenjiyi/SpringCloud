package com.gogoo.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Ribbon 自定义配置类
 * 注意：这个类不能放在能够被 @ComponentScan 扫描的包下以及子包下，@SpringBootApplication主启动类中包含该注解，该类的包下以及子包都将被扫描到
 * 否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，就无法达到特殊定制的目的
 */
@Configuration
public class MySelfRule
{
	@Bean
	public IRule myRule()
	{
		return new RandomRule_ZY(); //自定义轮询算法
		//return new RandomRule();// Ribbon默认是轮询，我自定义为随机
		//return new RoundRobinRule();// Ribbon默认是轮询
		
		//return new RandomRule_ZY();// 我自定义为每台机器5次
	}
}
