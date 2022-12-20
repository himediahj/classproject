package com.app.board.controller.todo;

import com.app.board.security.CustomUser;
import com.app.board.service.todo.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoViewController {

    @Autowired
    private TodoListService todoListService;

    @GetMapping("/todo/view")
    public void todoHome(@AuthenticationPrincipal CustomUser customUser, Model model){
        // model.addAttribute("todos", todoListService.selectAll(customUser.getBoardMember().getIdx()));
    }
}
