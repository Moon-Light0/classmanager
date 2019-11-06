package com.just.manager.service.impl;

import com.just.manager.dao.IPowerMapper;
import com.just.manager.dao.IStudentMapper;
import com.just.manager.domain.Power;
import com.just.manager.domain.Student;
import com.just.manager.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class StudentService implements IStudentService {
    @Autowired
    private IStudentMapper mapper;
    @Autowired
    private IPowerMapper powerMapper;


    @Override
    public boolean checkUserNameAndPassword(String username, String password) {
        return mapper.checkUserNameAndPassword(username,password);
    }

    @Override
    public Student findByStuNo(String stuNo) {
        return mapper.selectByStuNo(stuNo);
    }

    @Override
    public String findStuNameByStuNo(String stuNo) {
        return mapper.selectStuNameByStuNo(stuNo);
    }

    @Override
    public int update(Student student) {
        return mapper.update(student);
    }

    @Override
    public List<Student> findAll() {
        return mapper.selectAll();
    }

    @Override
    @Rollback
    public int add(Student student){
        student.setStuId(UUID.randomUUID().toString().substring(0,12));
        student.setClasses(Integer.valueOf(student.getStuNo().substring(9,10)));
        System.out.println(student);
        int num = mapper.insert(student);
        powerMapper.insert(new Power(UUID.randomUUID().toString().substring(0,12),student.getStuNo(),"USER"));
        return num;
    }

    @Override
    public int removeStudents(String[] stuNos) {
        return mapper.deleteMany(stuNos);
    }
}
