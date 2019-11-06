package com.just.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.just.manager.domain.HeadMaster;
import com.just.manager.service.IHeadMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/headmaster")
public class HeadMasterController {

    @Autowired
    private IHeadMasterService service;

    @RequestMapping("/findByHNo")
    public String getByHNo(String hNo, Model model){
        HeadMaster master = service.getByHNo(hNo);
        model.addAttribute("user",master);
        System.out.println("-------------------aa-");
        return "headmastermsg";
    }
    @RequestMapping("/findByHNo2")
    @ResponseBody
    public String getByHNo2(String hNo, Model model){
        HeadMaster master = service.getByHNo(hNo);
        model.addAttribute("user",master);
        System.out.println("-------------------aa-");
        return JSONObject.toJSONString(master);
    }
    @RequestMapping("/update")
    public String update(HeadMaster master,Model model){
        int num = service.update(master);
        model.addAttribute("user",service.getByHNo(master.getStuNo()));
        return "headmastermsg";
    }
}
