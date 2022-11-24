package com.app.emp.controller;

import com.app.emp.service.EmpDelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmpDelController {

    @Autowired
    private EmpDelService delService;

    @GetMapping("/emp/delete")
    public String deleteEmp(@RequestParam("empno") int empno){
        delService.delete(empno);
        return "redirect:/emp/list";
    }
}
