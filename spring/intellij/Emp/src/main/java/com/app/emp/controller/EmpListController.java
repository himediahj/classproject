package com.app.emp.controller;

import com.app.emp.service.EmpListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class EmpListController {
    @Autowired
    private EmpListService empListService;

    @RequestMapping("/emp/list")
    public void getEmpList(Model model){
        model.addAttribute("list", empListService.getList());
    }
}
