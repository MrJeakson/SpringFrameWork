package com.jt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class Index {

    @RequestMapping("/login")
    public String doLogin(){

        return "login";
    }

    @RequestMapping("/doAjax")

    public  String doAjax(){

        return "ajaxTest";
    }
    
    @RequestMapping("/doHello")
    public String doHello(){
        
        return "hello";
        }

}
