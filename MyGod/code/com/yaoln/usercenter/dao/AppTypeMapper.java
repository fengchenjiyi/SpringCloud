package com.yaoln.usercenter.dao;

import com.yaoln.usercenter.model.AppType;
import com.yaoln.usercenter.model.AppTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppTypeMapper {
    int countByExample(AppTypeExample example);

    int deleteByExample(AppTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppType record);

    int insertSelective(AppType record);

    List<AppType> selectByExample(AppTypeExample example);

    AppType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppType record, @Param("example") AppTypeExample example);

    int updateByExample(@Param("record") AppType record, @Param("example") AppTypeExample example);

    int updateByPrimaryKeySelective(AppType record);

    int updateByPrimaryKey(AppType record);
}