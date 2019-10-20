package com.yaoln.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yaoln.api.beans.PageInfo;
import com.yaoln.api.service.BaseServiceImpl;
import com.yaoln.api.utils.CommonUtils;
import com.yaoln.usercenter.enums.AppTypeEnum;
import com.yaoln.api.entitys.usercenter.AppType;
import com.yaoln.usercenter.model.OneUser;
import com.yaoln.usercenter.service.IAppTypeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: F~cjy
 * @Date: 2019/10/17 12:07
 */
@Service
public class AppTypeServiceImpl extends BaseServiceImpl<AppType> implements IAppTypeService {

    @Value("${page_num_max}")
    private int pageNumMax;

    @Override
    public int saveAppType(AppType appType) throws Exception{
        int rs = 0;
        QueryWrapper<AppType> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("tab_index");
        List<AppType> appTypes = super.queryAll(wrapper);
        if(appTypes == null || appTypes.size() == 0){
            appType.setTabIndex(1);
        }else {
            appType.setTabIndex(appTypes.get(0).getTabIndex() + 1);
        }

        if(appType.getTabIndex() <= AppTypeEnum.getAllType().length){
            appType.setTabName("tab_"+ AppTypeEnum.getValue(appType.getTabIndex())+"_user");
            appType.setAppKey(CommonUtils.uuid());
            rs = super.insert(appType);
        }
        return rs;
    }

    @Override
    public int updateAppType(AppType appType) throws Exception{
        return super.update(appType);
    }

    @Override
    public PageInfo<AppType> selectPageList(int pageNum, int pageSize) throws Exception{
        if(pageSize > pageNumMax){
            pageSize = pageNumMax;
        }
        QueryWrapper<AppType> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("create_time");
        IPage<AppType> iPage = super.queryPageList(queryWrapper, pageNum, pageSize);
        return new PageInfo<AppType>(iPage.getTotal(),pageNum,pageSize,iPage.getRecords());
    }
}
