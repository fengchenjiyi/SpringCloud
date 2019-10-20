package com.yaoln.usercenter.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 13:52
 * 自定义数据源，绑定配置文件中更多属性
 */
@Configuration
public class DruidConfiguration {

    Logger logger = LoggerFactory.getLogger(getClass());

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean(destroyMethod = "close", initMethod = "init")
    public DataSource druid(){
        return new DruidDataSource();
    }

    /**
     * 配置druid监控
     * 配置一个管理后台的Servlet
     * @return
     */
    @Autowired
    @Bean
    public ServletRegistrationBean statViewServlet(DruidConfigBean druidConfigBean){
        logger.info("开始初始化DruidConfig==============="+druidConfigBean.toString());
        //映射/druid/*请求路径
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> initParams = new HashMap<>();
        //设置登录名
        initParams.put("loginUsername",druidConfigBean.getLoginUsername());
        //设置登录密码
        initParams.put("loginPassword",druidConfigBean.getLoginPassword());
        //默认就是允许所有访问，允许访问的路径
        initParams.put("allow",druidConfigBean.getAllow());
        //拒绝访问
        initParams.put("deny",druidConfigBean.getDeny());
        bean.setInitParameters(initParams);
        return bean;
    }

    /**
     * 配置一个web监控的filter
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>();
        //不拦截的请求
        initParams.put("exclusions","*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        bean.setInitParameters(initParams);
        //拦截请求路径
        bean.setUrlPatterns(Arrays.asList("/*"));

        return  bean;
    }
}
