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
    public String main(){
        String method = "MainController.kong";
        exitMethod(method);
        return "user/index";
    }

    @GetMapping("/sub")
    public String sub(){
        String method = "MainController.sub";
        exitMethod(method);
        return "user/subPage";
    }


    private void exitMethod(String method){
        log.info("method={}",method);
    }
}
