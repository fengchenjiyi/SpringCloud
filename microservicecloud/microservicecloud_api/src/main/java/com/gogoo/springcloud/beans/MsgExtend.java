package com.gogoo.springcloud.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 29087 on 2018/10/30.
 * 前端JSON响应实体
 */
public class MsgExtend implements Serializable{

    /** 失败编码 */
    public static final int FAIL_CODE = 404;
    /** 成功编码 */
    public static final int SUCCESS_CODE = 200;

    //状态码   200-成功    404-失败
    private int code;
    //提示信息
    private String msg;

    //服务器要返回给浏览器的数据
    private Map<String, Object> extend = new HashMap<String, Object>();

    public static MsgExtend success(){
        MsgExtend result = new MsgExtend();
        result.setCode(SUCCESS_CODE);
        result.setMsg("处理成功！");
        return result;
    }

    public static MsgExtend fail(){
        MsgExtend result = new MsgExtend();
        result.setCode(FAIL_CODE);
        result.setMsg("处理失败！");
        return result;
    }

    public MsgExtend addErr(Object value){
        this.getExtend().put("errMsg", value);
        return this;
    }

    public MsgExtend addTokenErr(){
        this.getExtend().put("tokenErr", FAIL_CODE);
        return this;
    }

    public MsgExtend addMap(Map<String,Object> map){
        this.getExtend().putAll(map);
        return this;
    }

    public MsgExtend add(String key, Object value){
        this.getExtend().put(key, value);
        return this;
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

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
