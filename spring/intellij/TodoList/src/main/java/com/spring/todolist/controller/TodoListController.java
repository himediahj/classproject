package com.spring.todolist.controller;

import com.spring.todolist.service.todo.TodoListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoListController {
    private final TodoListService todoListService;

    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @RequestMapping("/todo/list")
    public void getTodoList(Model model){
        model.addAttribute("list", todoListService.getList());
    }
}
