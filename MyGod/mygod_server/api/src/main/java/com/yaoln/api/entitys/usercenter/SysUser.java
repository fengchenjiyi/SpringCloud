package com.yaoln.api.entitys.usercenter;

import com.baomidou.mybatisplus.annotation.TableName;

import com.yaoln.api.entitys.BaseUser;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 描述:tab_sys_user表的实体类
 * @version
 * @author:  290879584
 * @创建时间: 2019-10-17
 */
@Data
@Accessors(chain = true)
@TableName("tab_sys_user")
public class SysUser extends BaseUser {

    private static final long serialVersionUID = 2208035876822208785L;

    /**
     * 登录id
     */
    private String loginId;

}