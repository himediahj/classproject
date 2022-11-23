package com.todo.todospring.controller;

import com.todo.todospring.domain.TodoDTO;
import com.todo.todospring.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/todo/modify")
@Log4j2
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
    public String modifyPost(
//            @RequestParam("tno") int tno, @RequestParam("title") String title, @RequestParam("dueDate") String dueDate,
//            @RequestParam(value = "finished", required = false) String finished    꼭 값이 수정안되어도 되니까 (앞에 생략하고 그냥 String finished 써도 됨)
                            TodoDTO todoDTO){
        //TodoDTO todoDTO = new TodoDTO(tno, title, LocalDate.parse(dueDate), finished == null? false : true);
        log.info(todoDTO);  // finished = null이나 on이 아니라 포맷해서 true false로 찍힘
        todoService.getTodoModify(todoDTO);
        return "redirect:/todo/list";
    }
}
