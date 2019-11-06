package com.just.manager.domain;

import com.just.manager.utils.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 请假实体类
 */
public class Vacation {
    private String lId;  //假条id
    private String stuNo;  //学生id
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date leaveDate;  //请假日期
    private String leaveDateStr;  //请假日期str
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;  //结束日期
    private String returnDateStr;  //结束日期str
    private String reason;  //请假理由

    private Student student;

    public Vacation(){}

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setReturnDateStr(String returnDateStr) {
        this.returnDateStr = returnDateStr;
    }

    public void setLeaveDateStr(String leaveDateStr) {
        this.leaveDateStr = leaveDateStr;
    }

    public String getLeaveDateStr() {
        if(leaveDate != null){
            return DateUtil.date2String("yyyy-MM-dd",leaveDate);
        }
        return null;
    }

    public String getReturnDateStr() {
        if(returnDate != null){
            return DateUtil.date2String("yyyy-MM-dd",returnDate);
        }
        return null;
    }

    public void setlId(String lId) {
        this.lId = lId;
    }

    public String getlId() {
        return lId;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "lId='" + lId + '\'' +
                ", stuNo='" + stuNo + '\'' +
                ", leaveDate=" + leaveDate +
                ", returnDate=" + returnDate +
                ", reason='" + reason + '\'' +
                '}';
    }
}