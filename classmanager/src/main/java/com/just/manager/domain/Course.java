package com.just.manager.domain;

import java.util.Date;
import java.util.List;

public class Course {
    private String cId;  //课程id
    private String cName;  //课程名字
    private String credit;  //课程学分
    private String teacher;  //任课老师姓名
    private Date startDate;  //开课日期
    private Date endDate;  //结课日期

    private Score score;

    public Course(){}

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cId='" + cId + '\'' +
                ", cName='" + cName + '\'' +
                ", credit='" + credit + '\'' +
                ", teacher='" + teacher + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
