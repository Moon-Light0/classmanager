package com.just.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.just.manager.dao.IStudentMapper;
import com.just.manager.domain.Student;
import com.just.manager.service.IStudentService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService service;

    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(@RequestParam(defaultValue = "0") Integer pageNum,
                          @RequestParam(defaultValue = "5") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Student> students = service.findAll();
        PageInfo info = new PageInfo(students,5);
        return JSONObject.toJSONString(info);
    }
    @RequestMapping("/findIsStuNoExist")
    @ResponseBody
    public boolean findIsStuNoExist(String stuNo){
        Student student = service.findByStuNo(stuNo);
        if (student == null){
            return true;
        }
        return false;
    }

    @RequestMapping("/findByStuNo2")
    public String findStudent2(String stuNo){
        System.out.println(stuNo);
        Student student =  service.findByStuNo(stuNo);
        System.out.println(student);
        return JSONObject.toJSONString(student);
    }

    @RequestMapping("/findByStuNo")
    public String findStudent(String stuNo, Model model){
        System.out.println(stuNo);
        Student student =  service.findByStuNo(stuNo);
        System.out.println(student);
        model.addAttribute("user",student);
        return "mymsg";
    }

    @RequestMapping(value = "/findStuNameByStuNo")
    @ResponseBody
    public String findStuNameByStuNo(String stuNo){
        String stuName = service.findStuNameByStuNo(stuNo);
        if(stuName == null || stuName.equals("") ){
            return "";
        }
        return stuName;
    }
    @RequestMapping("/add")
    @ResponseBody
    public boolean add(@RequestBody Student student){
        int num = service.add(student);
        if (num == 1){
            return true;
        }
        return false;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public int deleteStudents(String stuNos){
        String[] strings = stuNos.split(",");
        int num = service.removeStudents(strings);
        return num;
    }

    @RequestMapping("/update")
    public String update(Student student,Model model){
        int num = service.update(student);
        model.addAttribute("user",service.findByStuNo(student.getStuNo()));
        return "mymsg";
    }
}
