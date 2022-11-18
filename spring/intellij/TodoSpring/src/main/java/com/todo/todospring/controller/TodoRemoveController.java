package com.todo.todospring.controller;

import com.todo.todospring.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoRemoveController {

    private final TodoService todoService;

    public TodoRemoveController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/todo/remove")
    public String removePost(@RequestParam("tno") int tno){
        todoService.getTodoRemove(tno);
        return "redirect:/todo/list";
    }
}
