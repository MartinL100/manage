package com.cong.checktime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InitController {

    @RequestMapping("/")
    public ModelAndView init(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/static/page/login.html");
        return mv;
    }
}
