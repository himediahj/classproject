package com.app.emp.controller;

import com.app.emp.domain.EmpDTO;
import com.app.emp.service.DeptListService;
import com.app.emp.service.EmpListService;
import com.app.emp.service.EmpRegService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp/register")
@Log4j2
public class EmpRegController {
    @Autowired
    private EmpRegService regService;

    @Autowired
    private EmpListService empListService;

    @Autowired
    private DeptListService deptListService;

    @GetMapping
    public void getRegForm(Model model){
        model.addAttribute("empList", empListService.getList());
        model.addAttribute("deptList", deptListService.getList());
    }

    @PostMapping
    public String reg(EmpDTO empDTO){
        log.info("reg Post...");
        log.info(empDTO);
        regService.insertEmp(empDTO);
        return "redirect:/emp/list";
    }
}
