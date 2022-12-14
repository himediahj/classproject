package com.spring.todolist.controller;

import com.spring.todolist.service.todo.TodoReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoReadController {
    @Autowired
    private TodoReadService todoReadService;

    @GetMapping("/todo/read")
    public void readTodo(Model model, @RequestParam("tno") int tno){
        model.addAttribute("todo", todoReadService.getTodo(tno));
    }
}
