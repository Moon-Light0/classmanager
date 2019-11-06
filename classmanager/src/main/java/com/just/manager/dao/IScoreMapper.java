package com.just.manager.dao;

import com.just.manager.domain.Score;

import java.util.List;

public interface IScoreMapper {

    public List<Score> selectByStuNo(String stuNo);
}
