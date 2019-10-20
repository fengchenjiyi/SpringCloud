package com.yaoln.api.utils;

import com.yaoln.api.beans.ResponseMsgBody;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/16 10:47
 * 校验工具类
 */
public class ValidatedUtils {

    /**
     * JSR303 校验错误信息
     * @param result
     * @return
     */
    public static ResponseMsgBody validated(BindingResult result){
        if(result.hasErrors()){
            //校验失败，应该返回失败
            List<FieldError> errors = result.getFieldErrors();
            Map<String,Object> map = new HashMap<>();
            for (FieldError fieldError : errors) {
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return ResponseMsgBody.fail().add("hint",map);
        }
        return ResponseMsgBody.success();
    }

    /**
     * 正则表达式校验数据
     * @param param 校验数据
     * @param regex 正则表达式
     * @return true：符合  false：不符合
     */
    public static boolean pattern(String param,String regex){
        if(null == param || param.isEmpty()
                || null == regex || regex.isEmpty()){
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(param);
        return matcher.find();
    }
}
