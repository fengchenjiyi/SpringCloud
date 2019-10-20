package com.yaoln.api.client.usercenter;

import com.yaoln.api.beans.ResponseMsgBody;
import com.yaoln.api.entitys.usercenter.AppType;
import com.yaoln.api.entitys.usercenter.AppUser;
import com.yaoln.api.entitys.usercenter.AppUserInfo;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/17 17:38
 */
@Component // 不要忘记添加，不要忘记添加
public class UserCenterClientFallback implements UserCenterClient {

    private ResponseMsgBody msgBody = ResponseMsgBody.fail().addErr("服务无响应");

    @Override
    public ResponseMsgBody addApp(AppType appType) {
        return msgBody;
    }

    @Override
    public ResponseMsgBody updateApp(AppType appType) {
        return msgBody;
    }

    @Override
    public ResponseMsgBody getPage(int pageNum, int pageSize) {
        return msgBody;
    }

    @Override
    public ResponseMsgBody regisUser(AppUser appUser) {
        return msgBody;
    }

    @Override
    public ResponseMsgBody addUser(AppUser appUser) {
        return msgBody;
    }

    @Override
    public ResponseMsgBody getUser(String appKey, String phone, String wx_id, String qq_id) {
        return msgBody;
    }

    @Override
    public ResponseMsgBody getUserName(String appKey, String userName) {
        return msgBody;
    }

    @Override
    public ResponseMsgBody updateUser(AppUser appUser) {
        return msgBody;
    }

    @Override
    public ResponseMsgBody updatePassword(AppUser appUser) {
        return msgBody;
    }

    @Override
    public ResponseMsgBody getAppUserPage(String appKey, int pageNum, int pageSize) {
        return msgBody;
    }

    @Override
    public ResponseMsgBody addUserInfo(AppUserInfo appUserInfo) {
        return msgBody;
    }

    @Override
    public ResponseMsgBody getAppUserInfoPage(String appKey, int pageNum, int pageSize) {
        return msgBody;
    }

    @Override
    public byte[] getImg(String codeKey) {
        return "SORRY".getBytes();
    }

    @Override
    public ResponseMsgBody verifyCode(String codeKey, String code) {
        return msgBody;
    }

}
