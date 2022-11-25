package com.spring.todolist.controller;

import com.spring.todolist.domain.TodoDTO;
import com.spring.todolist.service.todo.TodoEditService;
import com.spring.todolist.service.todo.TodoReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo/modify")
public class TodoModifyController {

    @Autowired
    private TodoReadService todoReadService;
    private final TodoEditService todoEditService;

    public TodoModifyController(TodoEditService todoEditService) {
        this.todoEditService = todoEditService;
    }



    @GetMapping
    public void getModifyForm(Model model, @RequestParam("tno") int tno){
        model.addAttribute("todo", todoReadService.getTodo(tno));
    }

    @PostMapping
    public String modifyPost(TodoDTO todoDTO){
        todoEditService.editTodo(todoDTO);
        return "redirect:/todo/list";
    }
}
