package com.spring.todolist.controller;

import com.spring.todolist.domain.TodoDTO;
import com.spring.todolist.service.todo.TodoRegService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@Log4j2
@RequestMapping("/todo/register")
public class TodoInsertController {

    private final TodoRegService todoRegService;

    public TodoInsertController(TodoRegService todoRegService) {
        this.todoRegService = todoRegService;
    }

    @GetMapping
    public String getInsertForm(){
        return "todo/register";
    }

    @PostMapping
    public String insert(@Valid TodoDTO todoDTO, BindingResult bindingResult){
        todoRegService.insertTodo(todoDTO);

        if(bindingResult.hasErrors()){
            log.info(bindingResult.getAllErrors());
        }
        return "redirect:/todo/list";
    }
}
