package com.spring.todolist.controller;

import com.spring.todolist.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoListController {
    private final TodoService todoService;

    public TodoListController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/todo/list")
    public void getTodoList(Model model){
        model.addAttribute("list", todoService.getTodoList());
    }
}
