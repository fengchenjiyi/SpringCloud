package com.yaoln.api.entitys.usercenter;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yaoln.api.entitys.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/17 11:02
 */
@Data
@Accessors(chain = true)
@TableName("tab_app_type")
public class AppType extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 2818093474399218705L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 应用名称
     */
    @NotBlank(message = "应用名称不能为空")
    @Size(max = 16,message = "应用名称不能超过16个字符")
    private String appName;

    /**
     * 表索引
     */
    private Integer tabIndex;

    /**
     * 表名
     */
    private String tabName;

    /**
     * 应用标识
     */
    private String appKey;

    /**
     * 应用描述
     */
    @Size(max = 256,message = "应用描述太长")
    private String description;
}
