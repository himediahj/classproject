package com.todo.todospring.controller;

import com.todo.todospring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoReadController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/todo/read")
    public void readTodo(Model model, @RequestParam("tno") int tno){

        model.addAttribute("todo", todoService.getTodoRead(tno));
        // return "todo/read"; //jsp파일
        // views Resolver 구조(return 주소)랑 mapping url이 같을 때 void 써도 됨
    }
}
