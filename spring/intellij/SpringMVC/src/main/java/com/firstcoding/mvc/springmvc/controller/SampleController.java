package com.firstcoding.mvc.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {
    @RequestMapping("/sample")
    public ModelAndView getSamplePage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("sample");  // => ViewResolver에서 /WEB-INF/views/sample.jsp
        return mav;
    }
    @RequestMapping("/sample2")
    public String getStringPage(){
        return "sample2";   // view 경로
    }

    @RequestMapping("/sample3")
    public void getVoidPage(){
        // 아무것도 없음
    }
}

