package com.just.manager.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.just.manager.domain.Reward;
import com.just.manager.service.IRewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.alibaba.druid.sql.dialect.mysql.ast.clause.MySqlFormatName.JSON;

@Controller
@RequestMapping("/reward")
public class RewardController {
    @Autowired
    private IRewardService service;

//    @RequestMapping("/findAll")
////    public String findPage(Integer pageNum, Integer pageSize,Model model){
////        if(pageNum == null) {
////            pageNum = 1;
////        }
////        if(pageSize == null ){
////            pageSize = 5;
////        }
////        System.out.println(pageNum + " " + pageSize);
////        PageHelper .startPage(pageNum,pageSize);
////        List<Reward> rewards = service.findAll();
////        PageInfo<Reward> info = new PageInfo<>(rewards,5);
////        model.addAttribute("pageInfo",info);
////        return "reward";
////    }
    @RequestMapping("/findByRewardDate")
    @ResponseBody
    public String findByRewardDate(Date rewardDate){
        Reward reward = service.findByRewardDate(rewardDate);
        return JSONObject.toJSONString(reward);
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public String findPageByStr(@RequestParam(defaultValue = "0") Integer pageNum,
                                @RequestParam(defaultValue = "5") Integer pageSize,
                                @RequestParam(defaultValue = "") String str){
        System.out.println(pageNum+ "   "+pageSize);
        PageHelper .startPage(pageNum,pageSize);
        List<Reward> rewards = null;
        if(str == null || str.length()==0){
            rewards =  service.findAll();
        }else{
            if(str.matches("\\d+")){
                System.out.println("aaa" + "str=" + str);
                rewards = service.findByStuNoLike(str);
                System.out.println( rewards.size()+"size++++++++++++++++++++");
            }else{
                rewards = service.findByStuNameLike(str);
            }
        }
        if(rewards == null || rewards.size() == 0){
            return "";
        }
        PageInfo<Reward> info = new PageInfo<>(rewards,5);
        return JSONObject.toJSONString(info);
    }

    //----------------------增---------------------------
    @RequestMapping("/addReward")
    @ResponseBody
    @RolesAllowed("ADMIN")
    public boolean addReward(@RequestBody Reward reward){
        System.out.println(reward);
        if(service.add(reward) == 1){
            return true;
        }
        return false;
    }
    //----------------------删---------------------------
    @RequestMapping("/removeReward")
    @ResponseBody
    @Secured("ROLE_ADMIN")
    public boolean removeReward(String rewardDateStrs){
        String[] rewardDates = rewardDateStrs.split(",");
        int num = 0;
        try {
            num = service.removeRewardByRewardDateStrs(rewardDates);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(num + "nummmmmmmmmm");
        if(num == rewardDates.length){
            return true;
        }
        return false;
    }
    //----------------------改---------------------------
    @RequestMapping("/update")
    @ResponseBody
    @RolesAllowed("ADMIN")
    public boolean update(@RequestBody Reward reward){
        System.out.println(reward);
        int num = service.update(reward);
        return num == 1 ? true: false;
    }

}
