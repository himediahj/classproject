package com.app.board.controller.todo;

import com.app.board.domain.todo.SearchTodo;
import com.app.board.security.CustomUser;
import com.app.board.service.todo.TodoListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class TodoViewController {

    @Autowired
    private TodoListService todoListService;

    @GetMapping("/todo/view")
    public void todoHome(){
    }

    @GetMapping("/todo/search")
    public String getSearch(Model model, @AuthenticationPrincipal CustomUser customUser, SearchTodo searchTodo){
        model.addAttribute("searchlist", todoListService.selectByTodo(searchTodo, customUser.getBoardMember().getIdx()));
        return "/todo/list";
    }


}
