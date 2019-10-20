package com.yaoln.usercenter.model;

import java.util.Date;

/**
 * 描述:tab_one_user表的实体类
 * @version
 * @author:  290879584
 * @创建时间: 2019-10-19
 */
public class OneUser {
    /**
     * id
     */
    private Long id;

    /**
     * 手机号
     */
    private Long phone;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 微信id
     */
    private String wxId;

    /**
     * QQid
     */
    private String qqId;

    /**
     * 头像图片地址
     */
    private String headImgUrl;

    /**
     * 性别，0：女，1：男
     */
    private Byte sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 用户状态，1：正常，0异常
     */
    private Byte status;

    /**
     * 最后一次登录时间
     */
    private Date loginTime;

    /**
     * 最后一次退出时间
     */
    private Date loginOutTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * id
     * @return id id
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 手机号
     * @return phone 手机号
     */
    public Long getPhone() {
        return phone;
    }

    /**
     * 手机号
     * @param phone 手机号
     */
    public void setPhone(Long phone) {
        this.phone = phone;
    }

    /**
     * 用户名
     * @return user_name 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 盐
     * @return salt 盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 盐
     * @param salt 盐
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 微信id
     * @return wx_id 微信id
     */
    public String getWxId() {
        return wxId;
    }

    /**
     * 微信id
     * @param wxId 微信id
     */
    public void setWxId(String wxId) {
        this.wxId = wxId == null ? null : wxId.trim();
    }

    /**
     * QQid
     * @return qq_id QQid
     */
    public String getQqId() {
        return qqId;
    }

    /**
     * QQid
     * @param qqId QQid
     */
    public void setQqId(String qqId) {
        this.qqId = qqId == null ? null : qqId.trim();
    }

    /**
     * 头像图片地址
     * @return head_img_url 头像图片地址
     */
    public String getHeadImgUrl() {
        return headImgUrl;
    }

    /**
     * 头像图片地址
     * @param headImgUrl 头像图片地址
     */
    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl == null ? null : headImgUrl.trim();
    }

    /**
     * 性别，0：女，1：男
     * @return sex 性别，0：女，1：男
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 性别，0：女，1：男
     * @param sex 性别，0：女，1：男
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 生日
     * @return birthday 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 生日
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 用户状态，1：正常，0异常
     * @return status 用户状态，1：正常，0异常
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 用户状态，1：正常，0异常
     * @param status 用户状态，1：正常，0异常
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 最后一次登录时间
     * @return login_time 最后一次登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 最后一次登录时间
     * @param loginTime 最后一次登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 最后一次退出时间
     * @return login_out_time 最后一次退出时间
     */
    public Date getLoginOutTime() {
        return loginOutTime;
    }

    /**
     * 最后一次退出时间
     * @param loginOutTime 最后一次退出时间
     */
    public void setLoginOutTime(Date loginOutTime) {
        this.loginOutTime = loginOutTime;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     * @return update_time 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}