package com.todo.mvc.todo.controller;

import com.todo.mvc.todo.dto.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
public class TodoRegisterController {

    @GetMapping("/register")
    public void register(){}

    @PostMapping("/register")
    public String registerPost(TodoDTO todoDTO){
        return "redirect:/todo/list";
    }
}
