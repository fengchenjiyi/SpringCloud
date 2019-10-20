package com.yaoln.usercenter.dao;

import com.yaoln.usercenter.model.OneUser;
import com.yaoln.usercenter.model.OneUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OneUserMapper {
    int countByExample(OneUserExample example);

    int deleteByExample(OneUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OneUser record);

    int insertSelective(OneUser record);

    List<OneUser> selectByExample(OneUserExample example);

    OneUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OneUser record, @Param("example") OneUserExample example);

    int updateByExample(@Param("record") OneUser record, @Param("example") OneUserExample example);

    int updateByPrimaryKeySelective(OneUser record);

    int updateByPrimaryKey(OneUser record);
}