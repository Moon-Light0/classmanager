package com.just.manager.domain;

import com.just.manager.utils.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Reward {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date rewardDate; //奖惩主键，用当前时间
    private String stuNo;   //学生id
    private String detail;  //细节
    private Integer isGood; //1，奖励 2，处分
    private String rewardDateStr;

    private Student student;

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public Reward(Date date, String stuNo, String mmmmm, int isGood){}

    public void setRewardDateStr(String rewardDateStr) {
        this.rewardDateStr = rewardDateStr;
    }

    public String getRewardDateStr() {
        return  DateUtil.date2String("yyyy-MM-dd HH:mm:ss",rewardDate);
    }

    public Date getRewardDate() {
        return rewardDate;
    }


    public void setIsGood(Integer isGood) {
        this.isGood = isGood;
    }

    public Integer getIsGood() {
        return isGood;
    }

    public void setRewardDate(Date rewardDate) {
        this.rewardDate = rewardDate;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "rewardDate=" + rewardDate +
                ", stuNo='" + stuNo + '\'' +
                ", detail='" + detail + '\'' +
                ", isGood=" + isGood +
                '}';
    }
    public Reward(){}
    public Reward(Date rewardDate , String stuNo, String detail, Integer isGood) {
        this.rewardDate = rewardDate;
        this.stuNo = stuNo;
        this.detail = detail;
        this.isGood = isGood;
    }
}
