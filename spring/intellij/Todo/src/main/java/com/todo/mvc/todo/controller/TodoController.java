package com.todo.mvc.todo.controller;

import com.todo.mvc.todo.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {
    @RequestMapping("/list")
    public void list(){

    }

    @GetMapping("/register")
    public void register(){

    }

    @PostMapping("/register")
    public String registerPost(TodoDTO todoDTO){

        return "redirect:/todo/list";
    }

    @GetMapping("/modify")
    public void modify(){

    }

    @PostMapping("/modify")
    public String modifyPost(){
        return "redirect:/todo/list";
    }

    @PostMapping("/remove")
    public String remove(){
        return "redirect:/todo/list";
    }

    @GetMapping("/read")
    public void read(){

    }
}
