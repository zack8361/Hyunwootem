package com.hyunwootem.hyunwootemproject.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@Slf4j
public class MainController {

    @GetMapping("/main")
    public String kong(){
        String method = "MainController.kong";
        log.info("method={}",method);
        return "user/index";
    }
}
