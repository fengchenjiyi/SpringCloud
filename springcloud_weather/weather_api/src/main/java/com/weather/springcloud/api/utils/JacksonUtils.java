package com.weather.springcloud.api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.springcloud.api.model.beans.ResponseMsgBody;

/**
 * @Auther: F~cjy
 * @Date: 2019/9/6 10:47
 */
public class JacksonUtils {

    // Jackson对象
    private static ObjectMapper objectMapper;

    private JacksonUtils(){}

    public static ObjectMapper getJackson(){
        if(objectMapper == null){
            synchronized (ResponseMsgBody.class) {
                if(objectMapper == null){
                    objectMapper = new ObjectMapper();
                }
            }
        }
        return objectMapper;
    }
}
