package com.yaoln.usercenter.service;

import com.yaoln.api.beans.PageInfo;
import com.yaoln.api.beans.ResponseMsgBody;
import com.yaoln.api.entitys.usercenter.AppUser;
import com.yaoln.api.entitys.usercenter.AppUserInfo;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/17 12:00
 */
public interface IAppUserInfoService {

    /**
     * 根据用户id查询信息
     * @param appKey 应用标识
     * @param userId
     * @return
     * @throws Exception
     */
    AppUserInfo selectByUserId(String appKey, Long userId) throws Exception;

    /**
     * 添加用户信息
     * @param appUserInfo
     * @return
     */
    int saveUserInfo(AppUserInfo appUserInfo) throws Exception;


    /**
     * 分页查询用户信息
     * @param appKey 应用标识
     * @param pageNum 页码
     * @param pageSize 页数据大小
     * @return
     * @throws Exception
     */
    PageInfo<AppUserInfo> selectPageList(String appKey, int pageNum, int pageSize) throws Exception;
}
