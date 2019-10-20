package com.yaoln.usercenter.dao;

import com.yaoln.usercenter.model.OneUserInfo;
import com.yaoln.usercenter.model.OneUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OneUserInfoMapper {
    int countByExample(OneUserInfoExample example);

    int deleteByExample(OneUserInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OneUserInfo record);

    int insertSelective(OneUserInfo record);

    List<OneUserInfo> selectByExample(OneUserInfoExample example);

    OneUserInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OneUserInfo record, @Param("example") OneUserInfoExample example);

    int updateByExample(@Param("record") OneUserInfo record, @Param("example") OneUserInfoExample example);

    int updateByPrimaryKeySelective(OneUserInfo record);

    int updateByPrimaryKey(OneUserInfo record);
}