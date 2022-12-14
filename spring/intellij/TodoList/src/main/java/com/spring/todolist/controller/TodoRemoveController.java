package com.spring.todolist.controller;

import com.spring.todolist.service.todo.TodoRemoveService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo/remove")
public class TodoRemoveController {

    private final TodoRemoveService todoRemoveService;

    public TodoRemoveController(TodoRemoveService todoRemoveService) {
        this.todoRemoveService = todoRemoveService;
    }

    @PostMapping
    public String remove(@RequestParam("tno") int tno){
        todoRemoveService.deleteTodo(tno);
        return "redirect:/todo/list";
    }
}
