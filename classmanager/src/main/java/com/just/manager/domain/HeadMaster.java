package com.just.manager.domain;

import java.util.List;

public class HeadMaster {
    private String hid; //班主任id
    private String stuName; //班主任姓名name
    private String stuNo; //学工号hno
    private String stuPwd; //登录密码hpwd
    private Integer sex;
    private Integer age;
    private String speciality; //专业
    private List<Power> powers;

    public HeadMaster() {
    }

    @Override
    public String toString() {
        return "HeadMaster{" +
                "hid='" + hid + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuNo='" + stuNo + '\'' +
                ", stuPwd='" + stuPwd + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", speciality='" + speciality + '\'' +
                ", powers=" + powers +
                '}';
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuPwd() {
        return stuPwd;
    }

    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public List<Power> getPowers() {
        return powers;
    }

    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }
}
