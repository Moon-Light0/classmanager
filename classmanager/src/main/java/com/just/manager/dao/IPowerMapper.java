package com.just.manager.dao;

import com.just.manager.domain.Power;

import java.util.List;

public interface IPowerMapper {


    List<Power> selectByStuNo(String s);

    int insert(Power power);

}
