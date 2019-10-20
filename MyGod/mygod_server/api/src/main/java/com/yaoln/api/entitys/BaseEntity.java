package com.yaoln.api.entitys;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.yaoln.api.constants.Cons;
import com.yaoln.api.utils.DateUtils;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/16 22:10
 */
@Data
public abstract class BaseEntity implements java.io.Serializable{

    @JsonFormat(pattern = Cons.Regexp.STANDART_DATE_REG)
    private Timestamp createTime;
    @JsonFormat(pattern = Cons.Regexp.STANDART_DATE_REG)
    private Timestamp updateTime;
}
