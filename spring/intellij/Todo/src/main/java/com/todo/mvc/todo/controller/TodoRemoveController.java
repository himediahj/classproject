package com.todo.mvc.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
public class TodoRemoveController {

    @PostMapping("/remove")
    public String remove(){
        return "redirect:/todo/list";
    }
}
