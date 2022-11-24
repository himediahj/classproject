package com.spring.todolist.controller;

import com.spring.todolist.domain.TodoDTO;
import com.spring.todolist.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo/modify")
public class TodoModifyController {
    private final TodoService todoService;

    public TodoModifyController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public void getModifyForm(Model model, @RequestParam("tno") int tno){
        model.addAttribute("todo", todoService.getTodoRead(tno));
    }

    @PostMapping
    public String modifyPost(TodoDTO todoDTO){
        todoService.getTodoModify(todoDTO);
        return "redirect:/todo/list";
    }
}
