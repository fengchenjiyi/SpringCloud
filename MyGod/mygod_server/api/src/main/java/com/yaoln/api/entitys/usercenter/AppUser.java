package com.yaoln.api.entitys.usercenter;

import com.yaoln.api.entitys.BaseUser;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/17 11:02
 */
@Data
@Accessors(chain = true)
public class AppUser extends BaseUser implements Serializable{

    private static final long serialVersionUID = 7054299425730643995L;

    /**
     * 微信id
     */
    private String wxId;

    /**
     * QQid
     */
    private String qqId;
}
