package com.yaoln.usercenter.service;

import com.yaoln.api.beans.PageInfo;
import com.yaoln.api.entitys.usercenter.AppType;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/17 12:00
 */
public interface IAppTypeService {

    /**
     * 添加应用
     * @param appType
     * @return
     */
    int saveAppType(AppType appType) throws Exception;

    /**
     * 修改应用
     * @param appType
     * @return
     */
    int updateAppType(AppType appType) throws Exception;

    /**
     * 分页查询应用
     * @param pageNum  页码
     * @param pageSize  页数据大小
     * @return
     */
    PageInfo<AppType> selectPageList(int pageNum, int pageSize) throws Exception;
}
