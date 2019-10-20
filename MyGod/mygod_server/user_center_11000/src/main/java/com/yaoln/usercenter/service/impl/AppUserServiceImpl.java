package com.yaoln.usercenter.service.impl;

import com.yaoln.api.beans.PageInfo;
import com.yaoln.api.beans.ResponseMsgBody;
import com.yaoln.api.entitys.usercenter.AppType;
import com.yaoln.api.entitys.usercenter.AppUser;
import com.yaoln.usercenter.enums.AppTypeEnum;
import com.yaoln.usercenter.service.IAppUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/18 01:15
 */
@Service
public class AppUserServiceImpl implements IAppUserService {

    @Autowired
    private AppTypeServiceImpl appTypeService;
    @Autowired
    private OneUserServiceImpl oneUserService;
    @Autowired
    private TwoUserServiceImpl twoUserService;

    @Override
    public AppUser selectByUserName(String appKey, String userName) throws Exception {
        AppUser appUser = null;
        if(StringUtils.isNotBlank(appKey)){
            AppType appType = new AppType();
            appType.setAppKey(appKey);
            appType = appTypeService.queryOne(appType);
            if(appType != null){
                if(AppTypeEnum.ONE.getTypeCode().equals(appType.getTabIndex())){
                    appUser = oneUserService.selectByUserName(appKey,userName);
                }else if(AppTypeEnum.TWO.getTypeCode().equals(appType.getTabIndex())){
                    appUser = twoUserService.selectByUserName(appKey,userName);
                }
            }
        }

        return appUser;
    }

    @Override
    public AppUser selectByUserId(String appKey, String phone, String wx_id, String qq_id) throws Exception {
        AppUser appUser = null;
        if(StringUtils.isNotBlank(appKey)){
            AppType appType = new AppType();
            appType.setAppKey(appKey);
            appType = appTypeService.queryOne(appType);
            if(appType != null){
                if(AppTypeEnum.ONE.getTypeCode().equals(appType.getTabIndex())){
                    appUser = oneUserService.selectByUserId(appKey,phone,wx_id,qq_id);
                }else if(AppTypeEnum.TWO.getTypeCode().equals(appType.getTabIndex())){
                    appUser = twoUserService.selectByUserId(appKey,phone,wx_id,qq_id);
                }
            }
        }

        return appUser;
    }

    @Override
    public ResponseMsgBody saveUser(AppUser appUser) throws Exception {
        if(StringUtils.isNotBlank(appUser.getAppKey())){
            AppType appType = new AppType();
            appType.setAppKey(appUser.getAppKey());
            appType = appTypeService.queryOne(appType);
            if(appType != null){
                //创建Random类对象
                Random random = new Random();
                //产生10-99随机数
                int number = random.nextInt(99 - 10 + 1) + 10;
                appUser.setId(Long.valueOf(""+System.currentTimeMillis()+number));
                if(AppTypeEnum.ONE.getTypeCode().equals(appType.getTabIndex())){
                    return oneUserService.saveUser(appUser);
                }else if(AppTypeEnum.TWO.getTypeCode().equals(appType.getTabIndex())){
                    return twoUserService.saveUser(appUser);
                }
            }
        }

        return ResponseMsgBody.fail().addErr("appKey无效");
    }

    @Override
    public ResponseMsgBody updateUser(AppUser appUser) throws Exception {
        if(StringUtils.isNotBlank(appUser.getAppKey())){
            AppType appType = new AppType();
            appType.setAppKey(appUser.getAppKey());
            appType = appTypeService.queryOne(appType);
            if(appType != null){
                if(AppTypeEnum.ONE.getTypeCode().equals(appType.getTabIndex())){
                    return oneUserService.updateUser(appUser);
                }else if(AppTypeEnum.TWO.getTypeCode().equals(appType.getTabIndex())){
                    return twoUserService.updateUser(appUser);
                }
            }
        }
        return ResponseMsgBody.fail().addErr("appKey无效");
    }

    @Override
    public PageInfo<AppUser> selectPageList(String appKey, int pageNum, int pageSize) throws Exception {
        PageInfo<AppUser> pageInfo = new PageInfo<>();
        if(StringUtils.isNotBlank(appKey)){
            AppType appType = new AppType();
            appType.setAppKey(appKey);
            appType = appTypeService.queryOne(appType);
            if(appType != null){
                if(AppTypeEnum.ONE.getTypeCode().equals(appType.getTabIndex())){
                    pageInfo = oneUserService.selectPageList(appKey,pageNum,pageSize);
                }else if(AppTypeEnum.TWO.getTypeCode().equals(appType.getTabIndex())){
                    pageInfo = twoUserService.selectPageList(appKey,pageNum,pageSize);
                }
            }
        }
        return pageInfo;
    }

}
