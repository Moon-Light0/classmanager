package com.just.manager.service.impl;

import com.just.manager.dao.IRewardMapper;
import com.just.manager.domain.Reward;
import com.just.manager.service.IRewardService;
import com.just.manager.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
@Transactional
public class RewardService implements IRewardService {
    @Autowired
    private IRewardMapper mapper;

    @Override
    public List<Reward> findAll() {
        return mapper.selectAll();
    }

    @Override
    public List<Reward> findByIsGood(Integer isGood) {
        return mapper.selectByIsGood(isGood);
    }

    @Override
    public List<Reward> findByStuNoLike(String stuNo) {
        return mapper.selectByStuNoLike(stuNo);
    }

    @Override
    public List<Reward> findByStuNameLike(String stuName) {
        return mapper.selectByStuNameLike(stuName);
    }

    @Override
    public Reward findByRewardDate(Date date) {
        return mapper.selectByRewardDate(date);
    }

    @Override
    public int add(Reward reward) {
        return mapper.insert(reward);
    }

    @Override
    public int update(Reward reward) {
        return mapper.update(reward);
    }

    @Override
    public int removeRewardByRewardDateStrs(String[] rewardDateStrs) throws ParseException {
        List<Date> rewardDates = new ArrayList<>();
        for (String r : rewardDateStrs){
            rewardDates.add(DateUtil.string2Date("yyyy-MM-dd HH:mm:ss",r));
        }
        return mapper.deleteByRewardDates(rewardDates);
    }

    @Override
    public int removeRewardByRewardDateStr(String rewardDate) throws ParseException {
        return mapper.deleteByRewardDate(DateUtil.string2Date("yyyy-MM-dd HH:mm:ss",rewardDate));
    }


}
