package com.yaoln.api.exception;

import java.io.Serializable;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/16 11:31
 * 自定义异常信息
 */
public class CustomException extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;
    //异常信息
    public String message;

    public CustomException(String message){
        super(message);
        this.message = message;
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
