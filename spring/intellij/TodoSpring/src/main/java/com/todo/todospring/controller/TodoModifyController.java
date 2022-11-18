package com.todo.todospring.controller;

import com.todo.todospring.domain.TodoDTO;
import com.todo.todospring.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/todo/modify")
public class TodoModifyController {

    private final TodoService todoService;

    public TodoModifyController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping
    public String getModifyForm(Model model, @RequestParam("tno") int tno){
        model.addAttribute("todo", todoService.getTodoRead(tno));
        return "todo/modify";
    }

    @PostMapping
    public String modifyPost(@RequestParam("tno") int tno, @RequestParam("title") String title, @RequestParam("dueDate") String dueDate,
                             @RequestParam(value = "finished", required = false) String finished){  // 꼭 값이 수정안되어도 되니까 (앞에 생략하고 그냥 String finished 써도 됨)
        TodoDTO todoDTO = new TodoDTO(tno, title, LocalDate.parse(dueDate), finished == null? false : true);
        todoService.getTodoModify(todoDTO);
        return "redirect:/todo/list";
    }
}
