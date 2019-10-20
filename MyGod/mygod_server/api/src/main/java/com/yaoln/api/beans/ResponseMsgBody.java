package com.yaoln.api.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yaoln.api.utils.JacksonUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/16 11:37
 * 前端JSON响应实体
 */
public class ResponseMsgBody implements Serializable {

    private static final long serialVersionUID = -7709108683372824798L;

    /** 失败编码 */
    public static final int FAIL_CODE = 404;
    /** 成功编码 */
    public static final int SUCCESS_CODE = 200;


    //状态码   200-成功    404-失败
    private int code;
    //提示信息
    private String msg;

    //服务器要返回给浏览器的数据
    private Map<String, Object> body = new HashMap<>();

    public static ResponseMsgBody success(){
        ResponseMsgBody rmb = new ResponseMsgBody();
        rmb.setCode(SUCCESS_CODE);
        rmb.setMsg("处理成功！");
        return rmb;
    }

    public static ResponseMsgBody fail(){
        ResponseMsgBody rmb = new ResponseMsgBody();
        rmb.setCode(FAIL_CODE);
        rmb.setMsg("处理失败！");
        return rmb;
    }

    public ResponseMsgBody addErr(Object value){
        this.getBody().put("errMsg", value);
        return this;
    }

    public ResponseMsgBody addTokenErr(){
        this.getBody().put("tokenErr", FAIL_CODE);
        return this;
    }

    public ResponseMsgBody addMap(Map<String,Object> map){
        this.getBody().putAll(map);
        return this;
    }

    public ResponseMsgBody add(String key, Object value){
        this.getBody().put(key, value);
        return this;
    }

    public ResponseMsgBody addDataJson(Object dataObj) {
        try {
            String dataJson = JacksonUtils.getJackson().writeValueAsString(dataObj);
            this.getBody().put("dataJson",dataJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @JsonIgnore
    public String getDataJson() {
        return (String) this.getBody().get("dataJson");
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getBody() {
        return body;
    }
}
