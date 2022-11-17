package com.todo.mvc.todo.controller;

import com.todo.mvc.todo.dto.TodoDTO;
import com.todo.mvc.todo.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoListController {

    @GetMapping("/list")
    public String list(){
       return "/todo/list";
    }
}
