package com.yaoln.usercenter.controller;

import com.yaoln.api.beans.ResponseMsgBody;
import com.yaoln.api.entitys.usercenter.AppUser;
import com.yaoln.api.utils.ValidatedUtils;
import com.yaoln.usercenter.service.impl.AppUserServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/17 22:20
 */
@RestController
@RequestMapping("/usercenter/appuser")
@CrossOrigin
public class AppUserController {

    @Autowired
    private AppUserServiceImpl appUserService;

    /**
     * 用户注册
     * @param appUser
     * @param result
     * @return
     * @throws Exception
     */
    @PostMapping("/regis")
    public ResponseMsgBody regisUser(@RequestBody @Validated AppUser appUser , BindingResult result) throws Exception{
        ResponseMsgBody response = ValidatedUtils.validated(result);
        if(response.getCode() == ResponseMsgBody.FAIL_CODE){
            return response;
        }
        if(StringUtils.isEmpty(appUser.getPhone())){
            return ResponseMsgBody.fail().addErr("手机号不能为空");
        }
        appUser.setWxId(null);
        appUser.setQqId(null);
        return appUserService.saveUser(appUser);
    }

    /**
     * 添加用户
     * @param appUser
     * @return
     */
    @PostMapping("/add")
    public ResponseMsgBody addUser(@RequestBody @Validated AppUser appUser , BindingResult result) throws Exception{
        ResponseMsgBody response = ValidatedUtils.validated(result);
        if(response.getCode() == ResponseMsgBody.FAIL_CODE){
            return response;
        }

        return appUserService.saveUser(appUser);
    }

    /**
     * 根据登录id查询用户信息
     * @param appKey
     * @param phone
     * @param wx_id
     * @param qq_id
     * @return
     * @throws Exception
     */
    @GetMapping("/user")
    public ResponseMsgBody getUser(@RequestParam(value="app_key") String appKey,
                                   @RequestParam(value="phone",required=false,defaultValue="") String phone,
                                   @RequestParam(value="wxid",required=false,defaultValue="") String wx_id,
                                   @RequestParam(value="qqid",required=false,defaultValue="") String qq_id) throws Exception {
        AppUser appUser = appUserService.selectByUserId(appKey,phone,wx_id,qq_id);
        if(appUser == null){
            return ResponseMsgBody.fail().addErr("未查询到用户信息");
        }
        appUser.setPassword(null);
        return ResponseMsgBody.success().add("user",appUser);
    }

    /**
     * 查询用户昵称是否注册
     * @return
     */
    @GetMapping("/uname")
    public ResponseMsgBody getUserName(@RequestParam(value="app_key") String appKey,
                                    @RequestParam(value="un") String userName) throws Exception {
        AppUser appUser = appUserService.selectByUserName(appKey, userName);
        if(appUser == null){
            return ResponseMsgBody.success();
        }
        return ResponseMsgBody.fail().addErr("昵称已被注册");
    }

    /**
     * 修改用户信息
     * @param appUser
     * @return
     */
    @PostMapping("/update")
    public ResponseMsgBody updateUser(@RequestBody @Validated AppUser appUser , BindingResult result) throws Exception{
        ResponseMsgBody response = ValidatedUtils.validated(result);
        if(response.getCode() == ResponseMsgBody.FAIL_CODE){
            return response;
        }

        return appUserService.updateUser(appUser);
    }

    /**
     * TODO 需要加强验证，如通过验证修改需要校验验证码一致性
     * 修改用户密码
     * @param appUser
     * @return
     * @throws Exception
     */
    @PostMapping("/uppwd")
    public ResponseMsgBody updatePassword(@RequestBody AppUser appUser) throws Exception {
        AppUser user = new AppUser();
        user.setAppKey(appUser.getAppKey());
        user.setId(appUser.getId());
        user.setPassword(appUser.getPassword());

        return appUserService.updateUser(user);
    }

    /**
     * 获取分页用户数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public ResponseMsgBody getPage(@RequestParam(value="app_key") String appKey,
                                   @RequestParam(value="pn",required=false,defaultValue="1") int pageNum,
                                   @RequestParam(value="ps",required=false,defaultValue="10") int pageSize) throws Exception{
        return ResponseMsgBody.success().add("pageInfo",appUserService.selectPageList(appKey,pageNum,pageSize));
    }
}
