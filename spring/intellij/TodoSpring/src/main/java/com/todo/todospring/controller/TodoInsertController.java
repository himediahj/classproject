package com.todo.todospring.controller;

import com.todo.todospring.domain.TodoDTO;
import com.todo.todospring.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/todo/register")
@Log4j2
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
    public String insert(   // @RequestParam("title") String title, @RequestParam("dueDate") String dueDate
                            TodoDTO todoDTO ){

        log.info(todoDTO.getTitle());
        log.info(todoDTO.getDueDate());
        log.info(todoDTO);

/*        TodoDTO todoDTO = TodoDTO.builder()
                .title(title)
                .dueDate(LocalDate.parse(dueDate))
                .build();*/

        log.info("todoDTO => " + todoDTO);

        todoService.getTodoRegister(todoDTO);

        return "redirect:/todo/list";
    }
}
