package com.gogoo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 配置文件中心微服务
 * 注意：服务能否正常从git上拉取配置文件，必须首先本地git客户端能够通过命令行正常上传下载配置文件，也就是本地和git服务连接没有问题
 */
@SpringBootApplication
@EnableConfigServer
public class Config_3344_StartSpringCloudApp
{
	public static void main(String[] args)
	{
		SpringApplication.run(Config_3344_StartSpringCloudApp.class, args);
	}
}
