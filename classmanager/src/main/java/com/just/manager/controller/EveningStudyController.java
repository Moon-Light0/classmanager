package com.just.manager.controller;

import com.just.manager.service.IEveningStudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EveningStudyController {
    @Autowired
    private IEveningStudyService service;


}
