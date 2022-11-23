package com.firstcoding.mvc.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping("/sample4")
    @ResponseBody   // 응답을 메소드 반환타입으로 응답처리
    public String page(){
        return "String Response ...";   // 아이디 중복여부 응답 메세지 용도..?
    }

    @RequestMapping("/sample5")
    @ResponseBody
    public String page2(int num){   // /sample5 들어가면 오류 뜸 /sample5?num=숫자
        String str = null;
        str.trim();
        return String.valueOf(num);
    }
}

