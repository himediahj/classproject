package com.todo.todospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String getIndex(){
        return "index"; // views 폴더 안에 index.jsp를 찾는다
    }
}
