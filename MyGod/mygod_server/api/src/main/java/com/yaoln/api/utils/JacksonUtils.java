package com.yaoln.api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaoln.api.beans.ResponseMsgBody;


/**
 * @Auther: F~cjy
 * @Date: 2019/10/16 10:47
 * JSON工具类
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
