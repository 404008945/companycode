package com.mvc.web.controller;

import com.mvc.web.entity.Entiy;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class TestController {

    @GetMapping("/test")
    @ResponseBody

    @ConfigurationPropertiesBinding
    public String test(Entiy entiy){
        return "2020-01-02";
    }

    @GetMapping("/test1")
    @ResponseBody
    public Entiy test(String p){
        Entiy entiy = new Entiy();
        entiy.setName(p);
        return entiy;
    }

    @GetMapping("/test2")
    @ResponseBody
    public Entiy test2(String p){
        Entiy entiy = new Entiy();
        entiy.setName(p);
        int a =1/0;
        return entiy;
    }

}
