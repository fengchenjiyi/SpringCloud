package com.yaoln.api.entitys;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yaoln.api.constants.Cons;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/17 10:56
 */
@Data
@Accessors(chain = true)
public abstract class BaseUser extends BaseEntity implements java.io.Serializable{

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 手机号
     */
    @Pattern(regexp = Cons.Regexp.PHONE_NUMBER_REG,message = "手机号码格式错误")
    @Size(max = 11,message = "手机号码格式错误")
    private String phone;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    @Size(max = 16,message = "用户名太长")
    private String userName;

    /**
     * 密码
     */

    private String password;

    /**
     * 盐
     */
    @JsonIgnore
    private String salt;

    /**
     * 头像图片地址
     */
    private String headImgUrl;

    /**
     * 性别，0：女，1：男
     */
    @NotNull(message = "性别不能为空")
    private Integer sex;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 用户状态，1：正常，0：异常
     */
    private Integer status;

    /**
     * 最后一次登录时间
     */
    @JsonFormat(pattern = Cons.Regexp.STANDART_DATE_REG)
    private Timestamp loginTime;

    /**
     * 最后一次退出时间
     */
    @JsonFormat(pattern = Cons.Regexp.STANDART_DATE_REG)
    private Timestamp loginOutTime;

    /**
     * 应用标识
     */
    @TableField(exist = false)
    private String appKey;
}
