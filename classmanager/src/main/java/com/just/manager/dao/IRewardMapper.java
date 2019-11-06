package com.just.manager.dao;

import com.just.manager.domain.Reward;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface IRewardMapper {

    /**
     * 根据主键查询奖惩记录
     * @param rewardDate
     * @return
     */
    public Reward selectByRewardDate(@Param("rewardDate")Date rewardDate);

    /**
     * 根据学号查询学生所有奖惩信息
     * @param stuNo
     * @return  rewards
     */
    public List<Reward> selectByStuNo(@Param("stuNo") String stuNo);
    /**
     * 查询所有学生的奖惩信息
     * @return rewards
     */
    public List<Reward> selectAll();

    /**
     * 查询所有奖励/处分信息的学生奖惩信息
     * @param isGood
     * @return rewards
     */
    public List<Reward> selectByIsGood(@Param("isGood") Integer isGood);

    /**
     * 添加学生奖惩信息
     * @param reward
     * @return 1 / 0
     */
    public int insert(Reward reward);

    /**
     * 删除一个学生奖惩信息
     * @param rewardDate 主键，新增时的时间戳
     * @return 1 / 0
     */
    public int deleteByRewardDate(@Param("rewardDate") Date rewardDate);

    /**
     * 修改学生奖惩信息
     * @param reward
     * @return 1 / 0
     */
    public int update(Reward reward);

    int deleteByRewardDates(@Param("rewardDates") List<Date> rewardDates);

    List<Reward> selectByStuNoLike(@Param("stuNo") String str);

    List<Reward> selectByStuNameLike(String stuName);
}
