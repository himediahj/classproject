package com.app.board.controller.emp;

import com.app.board.service.emp.EmpListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpListController {
    @Autowired
    private EmpListService empListService;

    @GetMapping("/emp/list")
    public void getList(Model model){
        model.addAttribute("list", empListService.selectAll());
    }
}
