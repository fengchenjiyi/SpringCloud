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
public class OneUserServiceImpl extends BaseServiceImpl<OneUser> implements IAppUserService {

    @Override
    public AppUser selectByUserName(String appKey, String userName) throws Exception {
        OneUser oneUser = new OneUser();
        oneUser.setUserName(userName);
        oneUser = queryOne(oneUser);
        if(oneUser == null){
            return null;
        }
        return toAppUser(oneUser);
    }

    @Override
    public AppUser selectByUserId(String appKey, String phone, String wx_id, String qq_id) throws Exception {
        OneUser oneUser = new OneUser();
        if(StringUtils.isEmpty(phone)
                && StringUtils.isEmpty(wx_id)
                && StringUtils.isEmpty(qq_id)){
            return null;
        }
        if(StringUtils.isNotBlank(phone)){
            oneUser.setPhone(phone);
        }
        if(StringUtils.isNotBlank(wx_id)){
            oneUser.setWxId(wx_id);
        }
        if(StringUtils.isNotBlank(qq_id)){
            oneUser.setQqId(qq_id);
        }
        oneUser = super.queryOne(oneUser);
        if(oneUser == null){
            return null;
        }
        return toAppUser(oneUser);
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

        OneUser oneUser = toOneUser(appUser);
        oneUser.setStatus(UserStatusEnum.NORMAL.getTypeCode());
        int rs = super.insert(oneUser);
        if(rs == 0){
            return ResponseMsgBody.fail().addErr("添加用户信息失败");
        }
        return ResponseMsgBody.success();
    }

    @Override
    public ResponseMsgBody updateUser(AppUser appUser) throws Exception {

        OneUser oneUser = super.queryById(appUser.getId());
        if(oneUser == null){
            return ResponseMsgBody.fail().addErr("用户信息未注册");
        }

        if(StringUtils.isNotBlank(appUser.getPhone())){
            if(checkByParam(appUser.getId(),"p",appUser.getPhone())){
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


        if(StringUtils.isNotBlank(appUser.getPassword())){
            if(StringUtils.isEmpty(oneUser.getSalt())){
                oneUser.setSalt(CommonUtils.uuid());
                appUser.setSalt(oneUser.getSalt());
            }
            appUser.setPassword(Md5Utils.MD5(appUser.getPassword()));
            appUser.setPassword(AesUtils.encryptAES(appUser.getPassword(),oneUser.getSalt()));
        }

        appUser.setCreateTime(null);
        int rs = super.update(toOneUser(appUser));
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
        QueryWrapper<OneUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        IPage<OneUser> page = super.queryPageList(queryWrapper, pageNum, pageSize);
        List<OneUser> oneUserList = page.getRecords();
        List<AppUser> appUserList = new ArrayList<>();
        for(OneUser oneUser : oneUserList){
            AppUser appUser = toAppUser(oneUser);
            appUser.setPassword(null);
            appUserList.add(appUser);
        }
        return new PageInfo<AppUser>(page.getTotal(),pageNum,pageSize,appUserList);
    }

    private boolean checkByParam(Long id, String field, String value){
        OneUser oneUser = new OneUser();
        switch (field){
            case "p":
                oneUser.setPhone(value);
                break;
            case "wi":
                oneUser.setWxId(value);
                break;
            case "qi":
                oneUser.setQqId(value);
                break;
            case "un":
                oneUser.setUserName(value);
                break;
        }

        QueryWrapper<OneUser> wrapper = new QueryWrapper<>(oneUser);
        //不等于当前id数据
        wrapper.ne("id",id);
        List<OneUser> userList = super.queryAll(wrapper);
        return (userList !=null && userList.size() > 0) ? true : false;
    }

    private OneUser toOneUser(AppUser appUser){
        OneUser oneUser = new OneUser();
        oneUser.setId(appUser.getId());
        oneUser.setPhone(appUser.getPhone());
        oneUser.setUserName(appUser.getUserName());

        if(StringUtils.isNotBlank(appUser.getPassword())){
            oneUser.setPassword(appUser.getPassword());
        }
        if(StringUtils.isNotBlank(appUser.getSalt())){
            oneUser.setSalt(appUser.getSalt());
        }

        oneUser.setWxId(appUser.getWxId());
        oneUser.setQqId(appUser.getQqId());
        oneUser.setHeadImgUrl(appUser.getHeadImgUrl());
        oneUser.setSex(appUser.getSex());
        oneUser.setBirthday(appUser.getBirthday());
        oneUser.setStatus(appUser.getStatus());

        return oneUser;
    }

    private AppUser toAppUser(OneUser oneUser){
        AppUser appUser = new AppUser();
        appUser.setId(oneUser.getId());
        appUser.setPhone(oneUser.getPhone());
        appUser.setUserName(oneUser.getUserName());
        appUser.setPassword(oneUser.getPassword());
        appUser.setSalt(oneUser.getSalt());
        appUser.setWxId(oneUser.getWxId());
        appUser.setQqId(oneUser.getQqId());
        appUser.setHeadImgUrl(oneUser.getHeadImgUrl());
        appUser.setSex(oneUser.getSex());
        appUser.setBirthday(oneUser.getBirthday());
        appUser.setStatus(oneUser.getStatus());
        appUser.setCreateTime(oneUser.getCreateTime());
        appUser.setLoginTime(oneUser.getLoginTime());

        return appUser;
    }
}
