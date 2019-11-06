package com.just.manager.service;

import com.just.manager.domain.Reward;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface IRewardService {
    List<Reward> findAll();

    List<Reward> findByIsGood(Integer isGood);

    int add(Reward reward);

    int update(Reward reward);

    int removeRewardByRewardDateStrs(String[] rewardDateStrs) throws ParseException;

    int removeRewardByRewardDateStr(String rewardDate) throws ParseException;

    List<Reward> findByStuNoLike(String stuNo);

    List<Reward> findByStuNameLike(String stuName);

    Reward findByRewardDate(Date date);
}
