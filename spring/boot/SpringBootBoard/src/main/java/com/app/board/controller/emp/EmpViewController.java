package com.app.board.controller.emp;

import com.app.board.service.emp.EmpViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmpViewController {
    @Autowired
    private EmpViewService empViewService;

    @GetMapping("/emp/view")
    public void view(Model model, @RequestParam("empno") int empno){
        model.addAttribute("view", empViewService.readEmp(empno));
    }
}
