package com.spring.todolist.controller;

import com.spring.todolist.domain.TodoDTO;
import com.spring.todolist.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo/register")
public class TodoInsertController {

    private final TodoService todoService;

    public TodoInsertController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String getInsertForm(){
        return "todo/register";
    }

    @PostMapping
    public String insert(TodoDTO todoDTO){
        todoService.getTodoReg(todoDTO);
        return "redirect:/todo/list";
    }
}
