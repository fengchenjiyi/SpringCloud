package com.yaoln.usercenter.controller;

import com.yaoln.api.beans.ResponseMsgBody;
import com.yaoln.api.utils.ValidatedUtils;
import com.yaoln.api.entitys.usercenter.AppType;
import com.yaoln.usercenter.service.IAppTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/17 15:50
 */
@RestController
@RequestMapping("/usercenter/app")
@CrossOrigin
public class AppTypeController {

    @Autowired
    private IAppTypeService appTypeService;

    /**
     * 添加应用
     * @param appType
     * @return
     */
    @PostMapping("/add")
    public ResponseMsgBody addApp(@RequestBody @Validated AppType appType , BindingResult result) throws Exception{
        ResponseMsgBody response = ValidatedUtils.validated(result);
        if(response.getCode() == ResponseMsgBody.FAIL_CODE){
            return response;
        }

        int rs = appTypeService.saveAppType(appType);
        if(rs == 0){
           return ResponseMsgBody.fail();
        }
        return ResponseMsgBody.success();
    }

    /**
     * 修改应用信息
     * @param appType
     * @return
     */
    @PostMapping("/update")
    public ResponseMsgBody updateApp(@RequestBody @Validated AppType appType , BindingResult result) throws Exception{
        ResponseMsgBody response = ValidatedUtils.validated(result);
        if(response.getCode() == ResponseMsgBody.FAIL_CODE){
            return response;
        }

        int rs = appTypeService.updateAppType(appType);
        if(rs == 0){
            return ResponseMsgBody.fail();
        }
        return ResponseMsgBody.success();
    }

    /**
     * 获取分页应用数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public ResponseMsgBody getPage(@RequestParam(value="pn",required=false,defaultValue="1") int pageNum,
                                         @RequestParam(value="ps",required=false,defaultValue="10") int pageSize) throws Exception{
        return ResponseMsgBody.success().add("pageInfo",appTypeService.selectPageList(pageNum,pageSize));
    }
}
