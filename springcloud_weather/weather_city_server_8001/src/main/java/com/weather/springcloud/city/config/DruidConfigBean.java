package com.weather.springcloud.city.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: F~cjy
 * @Date: 2019/8/31 13:52
 * Druid后台管理监控参数
 * @ConfigurationProperties：告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定；
 * prefix = "druid.configBean"：配置文件中哪个下面的所有属性进行一一映射
 *
 * @Component：只有这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties功能；
 */
@Component
@ConfigurationProperties(prefix = "mydruid")
public class DruidConfigBean {

    private String loginUsername;
    private String loginPassword;
    private String allow;
    private String deny;

    public String getLoginUsername() {
        return loginUsername == null ? "" : loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword == null ? "" : loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getAllow() {
        return allow == null ? "" : allow;
    }

    public void setAllow(String allow) {
        this.allow = allow;
    }

    public String getDeny() {
        return deny == null ? "" : deny;
    }

    public void setDeny(String deny) {
        this.deny = deny;
    }

    @Override
    public String toString() {
        return "DruidConfigBean{" +
                "loginUsername='" + loginUsername + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", allow='" + allow + '\'' +
                ", deny='" + deny + '\'' +
                '}';
    }
}
