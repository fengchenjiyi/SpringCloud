package com.yaoln.api.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/16 22:10
 * 分页实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo<T> implements java.io.Serializable {

    private static final long serialVersionUID = 4066328004063092416L;

    /**
     * 总条数
     */
    private Long total = 0L;

    /**
     * 当前页
     */
    private Integer pageNum = 0;

    /**
     * 一页显示的大小
     */
    private Integer pageSize = 0;

    /**
     * 数据列表
     */
    private List<T> records = Collections.emptyList();

}