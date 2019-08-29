package com.gogoo.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 290879584 on 2019/8/26.
 */
@Configuration
public class ConfigBean {



    /** 替换负载均衡算法 */
    @Bean
    public IRule myRule(){
        //return new RoundRobinRule(); //轮询
        return new RandomRule(); //随机分配
        //return new RetryRule();  //默认采用轮询，如果某个服务挂掉，访问3次该节点后仍然错误，下次访问就会跳过该节点，测试时候有点问题
    }
}
