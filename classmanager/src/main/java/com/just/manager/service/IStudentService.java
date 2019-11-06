package com.just.manager.service;

import com.just.manager.domain.Student;

import java.util.List;
import java.util.Map;

public interface IStudentService {
    public boolean checkUserNameAndPassword(String username,String password);

    Student findByStuNo(String stuNo);

    String findStuNameByStuNo(String stuNo);

    int update(Student student);

    List<Student> findAll();

    int add(Student student);

    int removeStudents(String[] strings);
}
