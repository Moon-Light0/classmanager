package com.just.manager.dao;

import com.just.manager.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IStudentMapper {
    /**
     * 根据学号获取
     * @param stuNo
     * @return
     */
    Student selectByStuNo(String stuNo);

    /**
     * 检验学号密码是否存在数据库
     * @param stuNo
     * @param stuPwd
     * @return 存在true，不存在false
     */
    boolean checkUserNameAndPassword( @Param("stuNo") String stuNo,@Param("stuPwd") String stuPwd);

    String selectStuNameByStuNo(@Param("stuNo") String stuNo);

    int update(Student student);

    List<Student> selectAll();

    int insert(Student student);

    int deleteMany(String[] stuNos);
}
