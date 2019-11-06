package com.just.manager.domain;

import com.just.manager.utils.DateUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 学生实体类
 * 数据较少，直接查出所有信息
 */
public class Student   {
    private String stuId; //学生id
    private String stuName; //学生姓名
    private String stuNo;   //学号
    private String stuPwd; //登录密码
    private String speciality; //专业
    private Integer classes; //班级
    private Integer dorm; //宿舍
    private Integer sex; //性别
    private Integer age; //年龄

    private Integer comeNum; //晚自习签到次数
    private List<String> notComeDates; //没有来的日期集合

    private List<Score> scores; //多个课程
    private List<EveningStudy> eveningStudies; //多条晚自习考勤信息
    private List<Reward> rewards; //多条奖惩信息
    private List<Vacation> vacations; //多条奖惩信息
    private List<Power> powers;
    public Student(){
    }

    public void setNotComeDates(List<String> notComeDates) {
        this.notComeDates = notComeDates;
    }
    public List<String> getNotComeDates() throws ParseException {
        List<String> notComeDates = new ArrayList<>();
        Date today = new Date();
        Date thatDay = DateUtil.string2Date("yyyy-MM-dd HH:mm:ss","2019-10-24 00:00:00");
        int days = (int)(today.getTime()-thatDay.getTime()) / 1000 / 3600 / 24;
        if (eveningStudies == null || eveningStudies.size() == 0){
            eveningStudies = new ArrayList<>();
        }
        for(int i = 0; i < days; i++){
            Date temp = new Date(today.getTime() - 1000*3600*24*i);
            for(EveningStudy study : eveningStudies){
                if (study.geteDate().getTime() == temp.getTime() ){
                    break;
                }
            }
            notComeDates.add(DateUtil.date2String("yyyy-MM-dd",temp));
        }
        return notComeDates;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Integer getClasses() {
        return classes;
    }

    public void setClasses(Integer classes) {
        this.classes = classes;
    }

    public Integer getDorm() {
        return dorm;
    }

    public void setDorm(Integer dorm) {
        this.dorm = dorm;
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

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public void setComeNum(Integer comeNum) {
        this.comeNum = comeNum;
    }

    public Integer getComeNum() {
        if(eveningStudies != null) {
            return eveningStudies.size();
        }
        return 0;
    }

    public List<EveningStudy> getEveningStudies() {
        if(eveningStudies != null){
            Calendar cal = Calendar.getInstance();
            String now = DateUtil.date2String("yyyy-MM-dd",cal.getTime());
            boolean flag = false;
            for (EveningStudy study : this.eveningStudies){
                if(now.equals(study.geteDateStr())){
                    flag = true;
                }
            }
            return eveningStudies;
        }
        return null;
    }

    public void setEveningStudies(List<EveningStudy> eveningStudies) {
        this.eveningStudies = eveningStudies;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public void setVacations(List<Vacation> vacations) {
        this.vacations = vacations;
    }

    public List<Vacation> getVacations() {
        return vacations;
    }

    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }

    public List<Power> getPowers() {
        return powers;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId='" + stuId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuNo='" + stuNo + '\'' +
                ", stuPwd='" + stuPwd + '\'' +
                ", speciality='" + speciality + '\'' +
                ", classes=" + classes +
                ", dorm=" + dorm +
                ", sex=" + sex +
                ", age=" + age +

                ", scores=" + scores +
                ", eveningStudies=" + eveningStudies +
                ", rewards=" + rewards +
                ", vacations=" + vacations +
                ", powers=" + powers +
                '}';
    }
}
