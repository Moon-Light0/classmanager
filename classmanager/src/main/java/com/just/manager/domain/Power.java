package com.just.manager.domain;

public class Power {
    private String pid;
    private String userId;
    private String role;

    private Student student;

    public  Power(){}

    public Power(String pid, String userId, String role) {
        this.pid = pid;
        this.userId = userId;
        this.role = role;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Power{" +
                "pid='" + pid + '\'' +
                ", userId='" + userId + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
