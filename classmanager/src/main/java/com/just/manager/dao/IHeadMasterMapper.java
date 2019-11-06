package com.just.manager.dao;

import com.just.manager.domain.HeadMaster;
import org.apache.ibatis.annotations.Param;

public interface IHeadMasterMapper {

    boolean checkUserNameAndPassword(@Param("hNo") String hNo, @Param("hPwd") String hPwd);

    HeadMaster getByHNo(String hNo);

    int update(HeadMaster master);
}
