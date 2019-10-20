package com.yaoln.api.client.usercenter;


import com.yaoln.api.entitys.usercenter.AppType;
import com.yaoln.api.beans.ResponseMsgBody;
import com.yaoln.api.entitys.usercenter.AppUser;
import com.yaoln.api.entitys.usercenter.AppUserInfo;
import com.yaoln.api.utils.ValidatedUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/17 17:37
 * 注意： 微服务的名字千万不能有下划线
 */
@FeignClient(name = "USER-CENTER", fallback = UserCenterClientFallback.class)
public interface UserCenterClient {

    /**
     * 添加应用
     * @param appType
     * @return
     */
    @PostMapping("/usercenter/app/add")
    ResponseMsgBody addApp(AppType appType);

    /**
     * 修改应用信息
     * @param appType
     * @return
     */
    @PostMapping("/usercenter/app/update")
    ResponseMsgBody updateApp(AppType appType);

    /**
     * 获取分页应用数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/usercenter/app/page")
    ResponseMsgBody getPage(@RequestParam(value="pn",required=false,defaultValue="1") int pageNum,
                            @RequestParam(value="ps",required=false,defaultValue="10") int pageSize);

    /**
     * 用户注册
     * @param appUser
     * @return
     */
    @PostMapping("/usercenter/appuser/regis")
    ResponseMsgBody regisUser(@RequestBody AppUser appUser);

    /**
     * 添加用户
     * @param appUser
     * @return
     */
    @PostMapping("/usercenter/appuser/add")
    ResponseMsgBody addUser(@RequestBody AppUser appUser);

    /**
     * 根据登录id查询用户信息
     * @param appKey
     * @param phone
     * @param wx_id
     * @param qq_id
     * @return
     */
    @GetMapping("/usercenter/appuser/user")
    ResponseMsgBody getUser(@RequestParam(value="app_key") String appKey,
                            @RequestParam(value="phone",required=false,defaultValue="") String phone,
                            @RequestParam(value="wxid",required=false,defaultValue="") String wx_id,
                            @RequestParam(value="qqid",required=false,defaultValue="") String qq_id);

    /**
     * 查询用户昵称是否注册
     * @return
     */
    @GetMapping("/usercenter/appuser/uname")
    ResponseMsgBody getUserName(@RequestParam(value="app_key") String appKey,
                                @RequestParam(value="un") String userName);

    /**
     * 修改用户信息
     * @param appUser
     * @return
     */
    @PostMapping("/usercenter/appuser/update")
    ResponseMsgBody updateUser(@RequestBody AppUser appUser);

    /**
     * 修改用户密码
     * @param appUser
     * @return
     * @throws Exception
     */
    @PostMapping("/usercenter/appuser/uppwd")
    ResponseMsgBody updatePassword(@RequestBody AppUser appUser);

    /**
     * 获取分页用户数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/usercenter/appuser/page")
    ResponseMsgBody getAppUserPage(@RequestParam(value="app_key") String appKey,
                            @RequestParam(value="pn",required=false,defaultValue="1") int pageNum,
                            @RequestParam(value="ps",required=false,defaultValue="10") int pageSize);

    /**
     * 添加用户信息
     * @param appUserInfo
     * @return
     */
    @PostMapping("/usercenter/appuserinfo/add")
    ResponseMsgBody addUserInfo(@RequestBody AppUserInfo appUserInfo );

    /**
     * 获取分页用户信息数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/usercenter/appuserinfo/page")
    ResponseMsgBody getAppUserInfoPage(@RequestParam(value="app_key") String appKey,
                                   @RequestParam(value="pn",required=false,defaultValue="1") int pageNum,
                                   @RequestParam(value="ps",required=false,defaultValue="10") int pageSize);

    /**
     * 获取动态验证码
     * @throws Exception
     */
    @GetMapping("/usercenter/verify/img")
    byte[] getImg(@RequestParam(value="code_key") String codeKey);

    /**
     * 验证码验证
     * @param code 验证码
     * @return
     */
    @PostMapping("/usercenter/verify/code")
    ResponseMsgBody verifyCode(@RequestParam(value="code_key") String codeKey,
                               @RequestParam(value="code") String code);

}
