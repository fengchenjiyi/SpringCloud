# microservicecloud结构说明，供个人学习所用
1. microservicecloud_api                         公共api，供其它微服务使用，集成Feign服务降级处理
2. microservicecloud_config_3344                 微服务Config服务端，供其它微服务动态更新配置文件
3. microservicecloud_config_client_3355          微服务Config客户端，测试动态更新配置文件
4. microservicecloud_config_dept_client_8001     能够自动更新配置文件的微服务提供者
5. microservicecloud_config_eureka_client_7001   能够自动更新配置文件的微服务注册中心
6. microservicecloud_consumer_dept_80            微服务消费者，RestTemplate进行http调用，Ribbon负载均衡，Ribbon负载均衡算法自定义
7. microservicecloud_consumer_dept_feign_80      微服务消费者，采用Feign进行服务降级处理及Ribbon负载均衡
8. microservicecloud_consumer_hystrix_dashboard  HystrixDashboard服务端，可进行未付状态监控
9. microservicecloud_eureka_7001                 微服务注册中心集群
10. microservicecloud_eureka_7002                微服务注册中心集群
11. microservicecloud_eureka_7003                微服务注册中心集群
12. microservicecloud_provider_dept_8001         微服务提供者
13. microservicecloud_provider_dept_8002         微服务提供者
14. microservicecloud_provider_dept_hystrix_8001 微服务提供者，具备Hystrix熔断处理
15. microservicecloud_zuul_gateway_9527          路由微服务提供者


# host文件映射：
        127.0.0.1	eureka7001.com     #注册服务中心
        127.0.0.1	eureka7002.com
        127.0.0.1	eureka7003.com
        127.0.0.1	myzuul.com           #路由中心
        127.0.0.1	config-3344.com   #配置文件更新中心
        127.0.0.1	client-config.com   #测试配置文件更新微服务
        Eureka：http://localhost:7001/     http://eureka7001.com:7001
        Hystrix：http://localhost:9001/hystrix
        HystrixDashboard：http://localhost:8001/hystrix.stream

        config配置中心：
          访问Git上基础配置文件开发环境：http://config-3344.com:3344/application-dev.yml
          访问Git上基础配置文件测试环境：http://config-3344.com:3344/application-test.yml
          其它访问方式：http://config-3344.com:3344/application/dev/master   输出json串，阅读不太方便
                       http://config-3344.com:3344/master/application-dev.yml   输出master分支中的配置文件，格式和第一种一样
        microservicecloud_config_client_3355客户端测试微服务：http://client-config.com:8201/config

# Git上传下载命令：
1、注意github上公钥配置  https://blog.csdn.net/yushuangping/article/details/84240863
2、cd 到对应目录
3、git status   查看文件状态，红色代表有更新
4、pwd  当前目录
5、git add .  将更新的文件添加进仓库
6、git commit -m "init file"   提交更新文件，并添加注释
7、git push origin master      将提交的内容推送到 master 分支
8、git clone git@github.com:fengchenjiyi/microservicecloud-config.git   克隆仓库

