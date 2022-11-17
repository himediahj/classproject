package com.todo.mvc.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
public class TodoModifyController {
    @GetMapping("/modify")
    public void modify(){}

    @PostMapping("/modify")
    public String modifyPost(){
        return "redirect:/todo/list";
    }
}
