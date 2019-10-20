package com.yaoln.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yaoln.api.beans.PageInfo;
import com.yaoln.api.beans.ResponseMsgBody;
import com.yaoln.api.constants.Cons;
import com.yaoln.api.entitys.usercenter.AppUser;
import com.yaoln.api.service.BaseServiceImpl;
import com.yaoln.api.utils.CommonUtils;
import com.yaoln.api.utils.DateUtils;
import com.yaoln.api.utils.encrypt.AesUtils;
import com.yaoln.api.utils.encrypt.Md5Utils;
import com.yaoln.usercenter.enums.UserStatusEnum;
import com.yaoln.usercenter.model.OneUser;
import com.yaoln.usercenter.model.TwoUser;
import com.yaoln.usercenter.service.IAppUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/17 22:16
 */
@Service
public class TwoUserServiceImpl extends BaseServiceImpl<TwoUser> implements IAppUserService {

    @Override
    public AppUser selectByUserName(String appKey, String userName) throws Exception {
        TwoUser twoUser = new TwoUser();
        twoUser.setUserName(userName);
        twoUser = queryOne(twoUser);
        if(twoUser == null){
            return null;
        }
        return toAppUser(twoUser);
    }

    @Override
    public AppUser selectByUserId(String appKey, String phone, String wx_id, String qq_id) throws Exception {
        TwoUser twoUser = new TwoUser();
        if(StringUtils.isEmpty(phone)
                && StringUtils.isEmpty(wx_id)
                && StringUtils.isEmpty(qq_id)){
            return null;
        }
        if(StringUtils.isNotBlank(phone)){
            twoUser.setPhone(phone);
        }
        if(StringUtils.isNotBlank(wx_id)){
            twoUser.setWxId(wx_id);
        }
        if(StringUtils.isNotBlank(qq_id)){
            twoUser.setQqId(qq_id);
        }
        twoUser = super.queryOne(twoUser);
        if(twoUser == null){
            return null;
        }
        return toAppUser(twoUser);
    }

    @Override
    public ResponseMsgBody saveUser(AppUser appUser) throws Exception {

        if(StringUtils.isEmpty(appUser.getPhone())
                && StringUtils.isEmpty(appUser.getWxId()) && StringUtils.isEmpty(appUser.getQqId())){
            return ResponseMsgBody.fail().addErr("无有效账户ID");
        }

        if(StringUtils.isNotBlank(appUser.getPhone())){
            AppUser user = selectByUserId(null,appUser.getPhone(),null,null);
            if(user != null){
                return ResponseMsgBody.fail().addErr("手机号已被注册");
            }
        }

        if(StringUtils.isNotBlank(appUser.getWxId())){
            AppUser user = selectByUserId(null,null, appUser.getWxId(),null);
            if(user != null){
                return ResponseMsgBody.fail().addErr("微信号已被注册");
            }
        }

        if(StringUtils.isNotBlank(appUser.getQqId())){
            AppUser user = selectByUserId(null,null, null, appUser.getQqId());
            if(user != null){
                return ResponseMsgBody.fail().addErr("QQ号已被注册");
            }
        }

        if(StringUtils.isNotBlank(appUser.getUserName())){
            AppUser user = selectByUserName(null,appUser.getUserName());
            if(user != null){
                return ResponseMsgBody.fail().addErr("昵称已被注册");
            }
        }

        if(StringUtils.isNotBlank(appUser.getBirthday())
                && !DateUtils.format(appUser.getBirthday(), Cons.Regexp.SIMPLE_DATE_REG)){
            return ResponseMsgBody.fail().addErr("生日格式错误");
        }
        if(StringUtils.isNotBlank(appUser.getPassword())){
            appUser.setSalt(CommonUtils.uuid());
            appUser.setPassword(Md5Utils.MD5(appUser.getPassword()));
            appUser.setPassword(AesUtils.encryptAES(appUser.getPassword(),appUser.getSalt()));
        }

        TwoUser twoUser = toTwoUser(appUser);
        twoUser.setStatus(UserStatusEnum.NORMAL.getTypeCode());
        int rs = super.insert(twoUser);
        if(rs == 0){
            return ResponseMsgBody.fail().addErr("添加用户信息失败");
        }
        return ResponseMsgBody.success();
    }

    @Override
    public ResponseMsgBody updateUser(AppUser appUser) throws Exception {

        TwoUser twoUser = super.queryById(appUser.getId());
        if(twoUser == null){
            return ResponseMsgBody.fail().addErr("用户信息未注册");
        }

        if(StringUtils.isNotBlank(appUser.getPhone())){
            if(checkByParam(appUser.getId(),"phone",appUser.getPhone())){
                return ResponseMsgBody.fail().addErr("手机号已被注册");
            }
        }

        if(StringUtils.isNotBlank(appUser.getWxId())){
            if(checkByParam(appUser.getId(),"wi",appUser.getWxId())){
                return ResponseMsgBody.fail().addErr("微信号已被注册");
            }
        }

        if(StringUtils.isNotBlank(appUser.getQqId())){
            if(checkByParam(appUser.getId(),"qi",appUser.getQqId())){
                return ResponseMsgBody.fail().addErr("QQ号已被注册");
            }
        }

        if(StringUtils.isNotBlank(appUser.getUserName())){
            if(checkByParam(appUser.getId(),"un",appUser.getUserName())){
                return ResponseMsgBody.fail().addErr("昵称已被注册");
            }
        }

        if(StringUtils.isNotBlank(appUser.getBirthday())
                && !DateUtils.format(appUser.getBirthday(), Cons.Regexp.SIMPLE_DATE_REG)){
            return ResponseMsgBody.fail().addErr("生日格式错误");
        }

        if(!StringUtils.isBlank(appUser.getPassword())){
            if(StringUtils.isEmpty(twoUser.getSalt())){
                twoUser.setSalt(CommonUtils.uuid());
                appUser.setSalt(twoUser.getSalt());
            }

            appUser.setPassword(Md5Utils.MD5(appUser.getPassword()));
            appUser.setPassword(AesUtils.encryptAES(appUser.getPassword(),twoUser.getSalt()));
        }

        appUser.setCreateTime(null);
        int rs = super.update(toTwoUser(appUser));
        if(rs == 0){
            return ResponseMsgBody.fail();
        }
        return ResponseMsgBody.success();
    }

    @Override
    public PageInfo<AppUser> selectPageList(String appKey, int pageNum, int pageSize) throws Exception {
        if(pageSize > pageNumMax){
            pageSize = pageNumMax;
        }
        QueryWrapper<TwoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        IPage<TwoUser> page = super.queryPageList(queryWrapper, pageNum, pageSize);
        List<TwoUser> twoUserList = page.getRecords();
        List<AppUser> appUserList = new ArrayList<>();
        for(TwoUser twoUser : twoUserList){
            AppUser appUser = toAppUser(twoUser);
            appUser.setPassword(null);
            appUserList.add(appUser);
        }
        return new PageInfo<AppUser>(page.getTotal(),pageNum,pageSize,appUserList);
    }

    private boolean checkByParam(Long id, String field, String value){
        TwoUser twoUser = new TwoUser();
        switch (field){
            case "phone":
                twoUser.setPhone(value);
                break;
            case "wi":
                twoUser.setWxId(value);
                break;
            case "qi":
                twoUser.setQqId(value);
                break;
            case "un":
                twoUser.setUserName(value);
                break;
        }

        QueryWrapper<TwoUser> wrapper = new QueryWrapper<>(twoUser);
        //不等于当前id数据
        wrapper.ne("id",id);
        List<TwoUser> userList = super.queryAll(wrapper);
        return (userList !=null && userList.size() > 0) ? true : false;
    }

    private TwoUser toTwoUser(AppUser appUser){
        TwoUser twoUser = new TwoUser();
        twoUser.setId(appUser.getId());
        twoUser.setPhone(appUser.getPhone());
        twoUser.setUserName(appUser.getUserName());

        if(StringUtils.isNotBlank(appUser.getPassword())){
            twoUser.setPassword(appUser.getPassword());
        }
        if(StringUtils.isNotBlank(appUser.getSalt())){
            twoUser.setSalt(appUser.getSalt());
        }

        twoUser.setWxId(appUser.getWxId());
        twoUser.setQqId(appUser.getQqId());
        twoUser.setHeadImgUrl(appUser.getHeadImgUrl());
        twoUser.setSex(appUser.getSex());
        twoUser.setBirthday(appUser.getBirthday());
        twoUser.setStatus(appUser.getStatus());

        return twoUser;
    }

    private AppUser toAppUser(TwoUser twoUser){
        AppUser appUser = new AppUser();
        appUser.setId(twoUser.getId()).setPhone(twoUser.getPhone());
        appUser.setUserName(twoUser.getUserName());
        appUser.setPassword(twoUser.getPassword());
        appUser.setSalt(twoUser.getSalt());
        appUser.setWxId(twoUser.getWxId());
        appUser.setQqId(twoUser.getQqId());
        appUser.setHeadImgUrl(twoUser.getHeadImgUrl());
        appUser.setSex(twoUser.getSex());
        appUser.setBirthday(twoUser.getBirthday());
        appUser.setStatus(twoUser.getStatus());
        appUser.setCreateTime(twoUser.getCreateTime());
        appUser.setLoginTime(twoUser.getLoginTime());

        return appUser;
    }
}
