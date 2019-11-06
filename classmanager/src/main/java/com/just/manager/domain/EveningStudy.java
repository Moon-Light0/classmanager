package com.just.manager.domain;
import com.just.manager.utils.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 晚自习实体类
 */
public class EveningStudy {
    private String eId;  //晚自习id
    private String stuNo;  //学生id
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date eDate;  //晚自习日期
    private String eDateStr;  //晚自习日期str
    private String content;  //晚自习内容

    private Student student;

    public EveningStudy(){}


    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void seteDateStr(String eDateStr) {
        this.eDateStr = eDateStr;
    }

    public String geteDateStr() {
        if(eDate != null){
            return DateUtil.date2String("yyyy-MM-dd",eDate);
        }
        return null;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String getStuId() {
        return stuNo;
    }

    public void setStuId(String StuNo) {
        this.stuNo = StuNo;
    }

    public Date geteDate() {
        return eDate;
    }

    public void seteDate(Date eDate) {
        this.eDate = eDate;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public EveningStudy(String eId, String stuNo, Date eDate, String eDateStr,   String content) {
        this.eId = eId;
        this.stuNo = stuNo;
        this.eDate = eDate;
        this.eDateStr = eDateStr;
        this.content = content;
    }

    @Override
    public String toString() {
        return "EveningStudy{" +
                "eId='" + eId + '\'' +
                ", stuNo='" + stuNo + '\'' +
                ", eDate=" + eDate +
                ", eDateStr='" + eDateStr + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
