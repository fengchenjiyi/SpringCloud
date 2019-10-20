package com.yaoln.api.entitys.usercenter;

import com.baomidou.mybatisplus.annotation.TableField;
import com.yaoln.api.entitys.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/17 11:02
 */
@Data
@Accessors(chain = true)
public class AppUserInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -1944236449050298981L;

    /**
     * id
     */
    private Long id;

    /**
     * 用户id
     */
    @NotNull(message = "用户id不能为空")
    private Long userId;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 设备型号
     */
    private String deviceModel;

    /**
     * ip地址
     */
    private String deviceIp;

    /**
     * 设备id
     */
    private String deviceId;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 国家
     */
    private String country;

    /**
     * 州
     */
    private String state;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 应用标识
     */
    @TableField(exist = false)
    private String appKey;
}