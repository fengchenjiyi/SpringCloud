工作中，去合作伙伴公司进行交接项目，聊起了他们公司现有的产品架构方案，说起了SpringCloud之微服务架构，感觉很不错，最近正好有空，就来研究学习下当下火热的微服务。在网上找到了很多学习资料，在此特别感谢IT界的大佬们，开源自己的学习心得和技术经验，让我们得以站在巨人的肩膀上成就自我。特别感谢[尚硅谷](http://www.atguigu.com/)免费学习视频教程，视频里的讲师都非常棒，也特别感谢大神[waylau](https://waylau.com/)。本次分享也是基于waylau所讲的天气预报微服务项目，融合了在尚硅谷中所学知识。希望方便供大家参考和自己学习，有写的不好的地方请多多指教。

## 项目环境

 - JDK1.8
 - IDEA  IntelliJ IDEA 2017.1.3
## 项目涉及技术
 - SpringCloud-Greenwich.SR2
 - SpringBoot-2.1.7.RELEASE
 - Mysql-5.5
 - Redis-win3.2
 - Maven-3.5
 - bootstrap4.0+Thymeleaf3.0.7
 
## SpringCloud系列
 
 - Config 自动化配置中心服务
 - Eureka 服务注册与发现
 - Actuator 传播应用程序，用来进行健康监控功能，提供了很多监控所需接口
 - Hystrix 服务熔断与降级
 - HystrixDashboard  服务API监控仪表盘服务
 - Feign 声明式Web服务端
 - Ribbon 负载均衡
 - Turbine 服务API监控聚合到HystrixDashboard仪表板
 - Zuul 路由网关
 - Zipkin 链路跟踪

## 话不多说，效果展示
 **1. 项目整体思路架构图**

 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20190907170744436.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3l5MjkwODc5NTg0,size_16,color_FFFFFF,t_70)
 
 **2. 项目UI效果**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190907135015734.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3l5MjkwODc5NTg0,size_16,color_FFFFFF,t_70)

 **3. 项目结构**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190907135128270.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3l5MjkwODc5NTg0,size_16,color_FFFFFF,t_70)

 **4. 项目完成Jar包目录及脚本启动**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190907135242672.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3l5MjkwODc5NTg0,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190907135303120.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3l5MjkwODc5NTg0,size_16,color_FFFFFF,t_70)
图中所有Jar包及脚本已上传百度云盘，需要的朋友可以直接下载：链接：https://pan.baidu.com/s/1avMtkee68AADej7uGoG5SA 
提取码：qm8q 

```java
运行Jar包注意事项：
1、需要先导入Mysql脚本，连接地址：localhost:3306，username: root，password: mysql
2、需要开启本地Redis，host: 127.0.0.1，port: 6379
3、需要修改系统host文件进行映射，否则Eureka服务启动和注册会出现问题
   127.0.0.1	eureka7201.com
   127.0.0.1	eureka7202.com
   127.0.0.1	eureka7205.com
4、city_server_8001、collection_server_8201会更新git上配置文件，不想更新关闭掉config_server_7001微服务即可
5、weather_demo是采用springboot做的一体天气预报系统，无需Mysql，需要Redis，配置同步骤2
6、建议机器内存8G以上
7、所有服务启动成功后，以本地为例，访问地址：
config_server_7001：http://localhost:7001/application-dev.yml

Eureka注册中心：http://localhost:7201/
               http://localhost:7202/
               http://localhost:7205/
               
city_server_8001：
         城市列表：http://localhost:8001/city/list
	   城市ID查询：http://localhost:8001/city/cityId/101280601
	 城市名称查询：http://localhost:8001/city/cityName/广州

data_server_8401：
	   城市ID查询：http://localhost:8401/weather/cityId/101280601
	 城市名称查询：http://localhost:8401/weather/cityName/深圳
	 
report_server_8601: http://localhost:8601/report/index
                    http://localhost:8601/report/cityId/101280101

Ribbon负载均衡：http://localhost:8801/weather/cityName/深圳
              刷新浏览器即可通过8401、8402两个cmd窗口查看效果
	 
consumer_server_8801：http://localhost:8801/city/list

zuul_gateway_server_9001：http://localhost:9001/test/rs/report/index
                          http://localhost:9001/test/consumer/city/list
                          http://localhost:9001/test/consumer/weather/cityId/101280601
						  
 Hystrix Dashboard主页：http://localhost:9201/hystrix
         操作方式请参考7图：http://localhost:8001/actuator/hystrix.stream
  Turbine，操作方式参考8图：localhost:9401/turbine.stream

zipkin-server链路跟踪效果：http://127.0.0.1:9411
```



 **5. Eureka集群效果**

![在这里插入图片描述](https://img-blog.csdnimg.cn/2019090713540070.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3l5MjkwODc5NTg0,size_16,color_FFFFFF,t_70)

 **6. Feign之Ribbon负载均衡效果**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190907135426193.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3l5MjkwODc5NTg0,size_16,color_FFFFFF,t_70)

 **7. HystrixDashboard监控效果**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190907135453856.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3l5MjkwODc5NTg0,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019090713551595.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3l5MjkwODc5NTg0,size_16,color_FFFFFF,t_70)

 **8. Turbine聚合效果**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190907135530209.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3l5MjkwODc5NTg0,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190907135546446.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3l5MjkwODc5NTg0,size_16,color_FFFFFF,t_70)

 **9. Zipkin链路跟踪效果**

![在这里插入图片描述](https://img-blog.csdnimg.cn/2019090713561210.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3l5MjkwODc5NTg0,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190907135624886.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3l5MjkwODc5NTg0,size_16,color_FFFFFF,t_70)
