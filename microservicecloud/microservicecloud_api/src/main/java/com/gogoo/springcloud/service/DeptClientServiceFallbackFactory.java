package com.gogoo.springcloud.service;

import com.gogoo.springcloud.beans.MsgExtend;
import com.gogoo.springcloud.entities.Dept;
import com.google.gson.Gson;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Created by 290879584 on 2019/8/27.
 * Hystrix熔断处理接口回调，AOP面向切面编程思想，对部门提供者服务接口进行一站式处理
 */
@Component // 不要忘记添加，不要忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    private Gson gson = new Gson();
    private MsgExtend msgExtend = MsgExtend.fail().addErr("Consumer客户端提供的降级信息,此刻服务Provider已经关闭");

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public String get(long id) {
                return gson.toJson(msgExtend);
            }

            @Override
            public String list() {
                return gson.toJson(msgExtend);
            }

            @Override
            public String add(Dept dept) {
                return gson.toJson(msgExtend);
            }

            @Override
            public Object discovery() {
                return gson.toJson(msgExtend);
            }
        };
    }
}
