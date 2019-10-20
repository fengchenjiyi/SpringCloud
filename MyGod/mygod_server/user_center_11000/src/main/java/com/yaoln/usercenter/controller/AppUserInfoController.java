package com.yaoln.usercenter.controller;

import com.yaoln.api.beans.ResponseMsgBody;
import com.yaoln.api.entitys.usercenter.AppUserInfo;
import com.yaoln.api.utils.ValidatedUtils;
import com.yaoln.usercenter.service.impl.AppUserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/19 00:54
 */
@RestController
@RequestMapping("/usercenter/appuserinfo")
@CrossOrigin
public class AppUserInfoController {

    @Autowired
    private AppUserInfoServiceImpl appUserInfoService;

    /**
     * 添加用户信息
     * @param appUserInfo
     * @return
     */
    @PostMapping("/add")
    public ResponseMsgBody addUserInfo(@RequestBody @Validated AppUserInfo appUserInfo , BindingResult result) throws Exception{
        ResponseMsgBody response = ValidatedUtils.validated(result);
        if(response.getCode() == ResponseMsgBody.FAIL_CODE){
            return response;
        }
        //数据存在不做修改
        AppUserInfo info = appUserInfoService.selectByUserId(appUserInfo.getAppKey(),appUserInfo.getUserId());
        if(info != null){
            return ResponseMsgBody.success();
        }

        int rs = appUserInfoService.saveUserInfo(appUserInfo);
        if(rs == 0){
            return ResponseMsgBody.fail();
        }
        return ResponseMsgBody.success();
    }

    /**
     * 获取分页用户信息数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public ResponseMsgBody getPage(@RequestParam(value="app_key") String appKey,
                                   @RequestParam(value="pn",required=false,defaultValue="1") int pageNum,
                                   @RequestParam(value="ps",required=false,defaultValue="10") int pageSize) throws Exception{
        return ResponseMsgBody.success().add("pageInfo",appUserInfoService.selectPageList(appKey,pageNum,pageSize));
    }
}
