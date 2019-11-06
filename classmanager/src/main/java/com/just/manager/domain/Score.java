package com.just.manager.domain;

import java.util.List;

public class Score {
    private String cId;     //课程id
    private String stuNo; //学号
    private Integer score; //成绩

    private Course course;

    public Score(){}

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "cId='" + cId + '\'' +
                ", stuNo='" + stuNo + '\'' +
                ", score=" + score +
                ", course=" + course +
                '}';
    }
}
