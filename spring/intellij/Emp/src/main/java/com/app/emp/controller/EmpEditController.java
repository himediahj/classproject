package com.app.emp.controller;

import com.app.emp.domain.EmpDTO;
import com.app.emp.service.EmpEditService;
import com.app.emp.service.EmpReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/emp/modify")
public class EmpEditController {
    @Autowired
    private EmpReadService empReadService;

    @Autowired
    private EmpEditService empEditService;

    @GetMapping
    public void getModifyForm(Model model, @RequestParam("no") int empno){
        model.addAttribute("list", empReadService.getRead(empno));
    }

    @PostMapping
    public String modify(EmpDTO empDTO){
        empEditService.updateEmp(empDTO);
        return "redirect:/emp/list";
    }
}
