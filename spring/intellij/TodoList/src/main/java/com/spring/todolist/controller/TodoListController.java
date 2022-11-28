package com.spring.todolist.controller;

import com.spring.todolist.domain.TodoSearchOption;
import com.spring.todolist.service.todo.TodoListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class TodoListController {
    private final TodoListService todoListService;

    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @RequestMapping("/todo/list")
    public void getTodoList(Model model, TodoSearchOption searchOption){
        log.info("todo list ...");
        model.addAttribute("list", todoListService.getSearchList(searchOption));
    }
}
