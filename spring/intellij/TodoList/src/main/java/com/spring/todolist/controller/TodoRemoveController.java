package com.spring.todolist.controller;

import com.spring.todolist.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo/remove")
public class TodoRemoveController {

    private final TodoService todoService;

    public TodoRemoveController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public String remove(@RequestParam("tno") int tno){
        todoService.getTodoRemove(tno);
        return "redirect:/todo/list";
    }
}
