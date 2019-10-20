package com.yaoln.usercenter.service.impl;

import com.yaoln.api.beans.PageInfo;
import com.yaoln.api.beans.ResponseMsgBody;
import com.yaoln.api.entitys.usercenter.AppType;
import com.yaoln.api.entitys.usercenter.AppUserInfo;
import com.yaoln.usercenter.enums.AppTypeEnum;
import com.yaoln.usercenter.service.IAppUserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/19 00:58
 */
@Service
public class AppUserInfoServiceImpl implements IAppUserInfoService{

    @Autowired
    private AppTypeServiceImpl appTypeService;
    @Autowired
    private OneUserInfoServiceImpl oneUserInfoService;

    @Override
    public AppUserInfo selectByUserId(String appKey, Long userId) throws Exception {
        AppUserInfo userInfo = null;
        if(StringUtils.isNotBlank(appKey)){
            AppType appType = new AppType();
            appType.setAppKey(appKey);
            appType = appTypeService.queryOne(appType);
            if(appType != null){
                if(AppTypeEnum.ONE.getTypeCode().equals(appType.getTabIndex())){
                    userInfo = oneUserInfoService.selectByUserId(appKey,userId);
                }
            }
        }

        return userInfo;
    }

    @Override
    public int saveUserInfo(AppUserInfo appUserInfo) throws Exception {
        int rs = 0;
        if(StringUtils.isNotBlank(appUserInfo.getAppKey())){
            AppType appType = new AppType();
            appType.setAppKey(appUserInfo.getAppKey());
            appType = appTypeService.queryOne(appType);
            if(appType != null){
                //创建Random类对象
                Random random = new Random();
                //产生10-99随机数
                int number = random.nextInt(99 - 10 + 1) + 10;
                appUserInfo.setId(Long.valueOf(""+System.currentTimeMillis()+number));
                if(AppTypeEnum.ONE.getTypeCode().equals(appType.getTabIndex())){
                    rs =  oneUserInfoService.saveUserInfo(appUserInfo);
                }
            }
        }

        return rs;
    }

    @Override
    public PageInfo<AppUserInfo> selectPageList(String appKey, int pageNum, int pageSize) throws Exception {
        PageInfo<AppUserInfo> pageInfo = new PageInfo<>();
        if(StringUtils.isNotBlank(appKey)){
            AppType appType = new AppType();
            appType.setAppKey(appKey);
            appType = appTypeService.queryOne(appType);
            if(appType != null){
                if(AppTypeEnum.ONE.getTypeCode().equals(appType.getTabIndex())){
                    pageInfo = oneUserInfoService.selectPageList(appKey,pageNum,pageSize);
                }
            }
        }

        return pageInfo;
    }
}
