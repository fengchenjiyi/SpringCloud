package com.yaoln.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yaoln.api.beans.PageInfo;
import com.yaoln.api.entitys.usercenter.AppUserInfo;
import com.yaoln.api.service.BaseServiceImpl;
import com.yaoln.usercenter.model.OneUserInfo;
import com.yaoln.usercenter.service.IAppUserInfoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/19 01:00
 */
@Service
public class OneUserInfoServiceImpl extends BaseServiceImpl<OneUserInfo> implements IAppUserInfoService{

    @Override
    public AppUserInfo selectByUserId(String appKey, Long userId) throws Exception {
        OneUserInfo userInfo = new OneUserInfo();
        userInfo.setUserId(userId);
        userInfo = super.queryOne(userInfo);
        if(userInfo == null){
            return null;
        }
        return toAppUserInfo(userInfo);
    }

    @Override
    public int saveUserInfo(AppUserInfo appUserInfo) throws Exception {
        return super.insert(toOneUserInfo(appUserInfo));
    }

    @Override
    public PageInfo<AppUserInfo> selectPageList(String appKey, int pageNum, int pageSize) throws Exception {
        if(pageSize > pageNumMax){
            pageSize = pageNumMax;
        }
        QueryWrapper<OneUserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        IPage<OneUserInfo> page = super.queryPageList(queryWrapper, pageNum, pageSize);
        List<OneUserInfo> oneUserinfoList = page.getRecords();
        List<AppUserInfo> appUserinfoList = new ArrayList<>();
        for(OneUserInfo oneUserInfo : oneUserinfoList){
            AppUserInfo appUserInfo = toAppUserInfo(oneUserInfo);
            appUserinfoList.add(appUserInfo);
        }
        return new PageInfo<AppUserInfo>(page.getTotal(),pageNum,pageSize,appUserinfoList);
    }

    private AppUserInfo toAppUserInfo(OneUserInfo userInfo) {
        AppUserInfo info = new AppUserInfo();
        info.setId(userInfo.getId());
        info.setUserId(userInfo.getUserId());
        info.setDeviceName(userInfo.getDeviceName());
        info.setDeviceModel(userInfo.getDeviceModel());
        info.setDeviceIp(userInfo.getDeviceIp());
        info.setDeviceId(userInfo.getDeviceId());
        info.setLongitude(userInfo.getLongitude());
        info.setLatitude(userInfo.getLatitude());
        info.setCountry(userInfo.getCountry());
        info.setState(userInfo.getState());
        info.setProvince(userInfo.getProvince());
        info.setCity(userInfo.getCity());
        info.setCreateTime(userInfo.getCreateTime());

        return info;
    }

    private OneUserInfo toOneUserInfo(AppUserInfo userInfo) {
        OneUserInfo info = new OneUserInfo();
        info.setId(userInfo.getId());
        info.setUserId(userInfo.getUserId());
        info.setDeviceName(userInfo.getDeviceName());
        info.setDeviceModel(userInfo.getDeviceModel());
        info.setDeviceIp(userInfo.getDeviceIp());
        info.setDeviceId(userInfo.getDeviceId());
        info.setLongitude(userInfo.getLongitude());
        info.setLatitude(userInfo.getLatitude());
        info.setCountry(userInfo.getCountry());
        info.setState(userInfo.getState());
        info.setProvince(userInfo.getProvince());
        info.setCity(userInfo.getCity());
        info.setCreateTime(userInfo.getCreateTime());

        return info;
    }
}
