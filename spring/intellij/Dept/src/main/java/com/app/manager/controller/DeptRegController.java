package com.app.manager.controller;

import com.app.manager.domain.DeptDTO;
import com.app.manager.service.DeptRegService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dept/register")
@Log4j2
public class DeptRegController {

    @Autowired
    private DeptRegService regService;

    @GetMapping
    public void getRegForm(){
        log.info("regForm ...");
    }

    @PostMapping
    public String reg(DeptDTO deptDTO){
        log.info("reg Post ...");
        log.info(deptDTO);
        regService.insertDept(deptDTO);
        return "redirect:/dept/list";
    }
}
