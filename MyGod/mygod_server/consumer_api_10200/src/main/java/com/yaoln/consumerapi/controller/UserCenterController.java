package com.yaoln.consumerapi.controller;

import com.yaoln.api.beans.ResponseMsgBody;
import com.yaoln.api.client.usercenter.UserCenterClient;
import com.yaoln.api.entitys.usercenter.AppType;
import com.yaoln.api.entitys.usercenter.AppUser;
import com.yaoln.api.entitys.usercenter.AppUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/17 18:21
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserCenterController {

    @Autowired
    private UserCenterClient userCenterClient;


    /**
     * 添加应用
     * @param appType
     * @return
     */
    @PostMapping("/app/add")
    public ResponseMsgBody addApp(@RequestBody AppType appType){
        return userCenterClient.addApp(appType);
    }

    /**
     * 修改应用信息
     * @param appType
     * @return
     */
    @PostMapping("/app/update")
    public ResponseMsgBody updateApp(@RequestBody AppType appType){
        return userCenterClient.updateApp(appType);
    }

    /**
     * 获取分页应用数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/app/page")
    public ResponseMsgBody getPage(@RequestParam(value="pn",required=false,defaultValue="1") int pageNum,
                                   @RequestParam(value="ps",required=false,defaultValue="10") int pageSize){
        return userCenterClient.getPage(pageNum,pageSize);
    }

    /**
     * 用户注册
     * @param appUser
     * @return
     * @throws Exception
     */
    @PostMapping("/regis")
    public ResponseMsgBody regisUser(@RequestBody AppUser appUser) {
        return userCenterClient.regisUser(appUser);
    }

    /**
     * 添加用户
     * @param appUser
     * @return
     */
    @PostMapping("/add")
    public ResponseMsgBody addUser(@RequestBody AppUser appUser){
        return userCenterClient.addUser(appUser);
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
    @GetMapping("/id")
    public ResponseMsgBody getUser(@RequestParam(value="app_key") String appKey,
                                   @RequestParam(value="phone",required=false,defaultValue="") String phone,
                                   @RequestParam(value="wxid",required=false,defaultValue="") String wx_id,
                                   @RequestParam(value="qqid",required=false,defaultValue="") String qq_id){
        return userCenterClient.getUser(appKey,phone,wx_id,qq_id);
    }

    /**
     * 查询用户昵称是否注册
     * @return
     */
    @GetMapping("/uname")
    public ResponseMsgBody getUserName(@RequestParam(value="app_key") String appKey,
                                       @RequestParam(value="un") String userName){
        return userCenterClient.getUserName(appKey,userName);
    }

    /**
     * 修改用户信息
     * @param appUser
     * @return
     */
    @PostMapping("/update")
    public ResponseMsgBody updateUser(@RequestBody AppUser appUser){
        return userCenterClient.updateUser(appUser);
    }

    /**
     * 修改用户密码
     * @param appUser
     * @return
     * @throws Exception
     */
    @PostMapping("/upwd")
    public ResponseMsgBody updatePassword(@RequestBody AppUser appUser){
        return userCenterClient.updatePassword(appUser);
    }

    /**
     * 获取分页用户数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public ResponseMsgBody getAppUserPage(@RequestParam(value="app_key") String appKey,
                                   @RequestParam(value="pn",required=false,defaultValue="1") int pageNum,
                                   @RequestParam(value="ps",required=false,defaultValue="10") int pageSize){
        return userCenterClient.getAppUserPage(appKey,pageNum,pageSize);
    }

    /**
     * 添加用户信息
     * @param appUserInfo
     * @return
     */
    @PostMapping("/info/add")
    public ResponseMsgBody addUserInfo(@RequestBody AppUserInfo appUserInfo){
        return userCenterClient.addUserInfo(appUserInfo);
    }

    /**
     * 获取分页用户信息数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/info/page")
    public ResponseMsgBody getPage(@RequestParam(value="app_key") String appKey,
                                   @RequestParam(value="pn",required=false,defaultValue="1") int pageNum,
                                   @RequestParam(value="ps",required=false,defaultValue="10") int pageSize) throws Exception{
        return userCenterClient.getAppUserInfoPage(appKey,pageNum,pageSize);
    }

    /**
     * 获取动态验证码
     * @throws Exception
     */
    @GetMapping("/verify/img.jpg")
    public void getImg(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
        HttpSession session = httpServletRequest.getSession();
        byte[] img = userCenterClient.getImg(session.getId());
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(img);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    /**
     * 验证码验证
     * @param code 验证码
     * @return
     */
    @PostMapping("/verify/code")
    public ResponseMsgBody verifyCode(String code, HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        return userCenterClient.verifyCode(session.getId(),code);
    }
}
