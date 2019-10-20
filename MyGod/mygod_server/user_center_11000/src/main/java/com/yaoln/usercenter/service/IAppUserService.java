package com.yaoln.usercenter.service;

import com.yaoln.api.beans.PageInfo;
import com.yaoln.api.beans.ResponseMsgBody;
import com.yaoln.api.entitys.usercenter.AppUser;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/17 12:00
 */
public interface IAppUserService {

    /**
     * 根据用户昵称查询用户
     * @param appKey 应用标识
     * @param userName
     * @return
     * @throws Exception
     */
    AppUser selectByUserName(String appKey, String userName) throws Exception;

    /**
     * 根据用户登录id查询用户信息
     * @param appKey 应用标识
     * @param phone
     * @param wx_id
     * @param qq_id
     * @return
     * @throws Exception
     */
    AppUser selectByUserId(String appKey, String phone, String wx_id, String qq_id) throws Exception;

    /**
     * 添加用户
     * @param appUser
     * @return
     */
    ResponseMsgBody saveUser(AppUser appUser) throws Exception;

    /**
     * 修改用户
     * @param appUser
     * @return
     */
    ResponseMsgBody updateUser(AppUser appUser) throws Exception;

    /**
     * 分页查询用户
     * @param appKey 应用标识
     * @param pageNum 页码
     * @param pageSize 页数据大小
     * @return
     * @throws Exception
     */
    PageInfo<AppUser> selectPageList(String appKey, int pageNum, int pageSize) throws Exception;
}
