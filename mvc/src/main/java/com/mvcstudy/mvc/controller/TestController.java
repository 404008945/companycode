package com.mvcstudy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @ResponseBody
    @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("name","hello");
     return "/index";
    }

}
