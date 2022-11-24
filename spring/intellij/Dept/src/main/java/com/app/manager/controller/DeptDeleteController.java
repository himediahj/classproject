package com.app.manager.controller;

import com.app.manager.service.DeptDelService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
public class DeptDeleteController {

    @Autowired
    private DeptDelService deptDelService;

    @GetMapping("/dept/delete")
    public String deleteDept(@RequestParam("deptno") int deptno){
        log.info("delete ..." + deptno);
        deptDelService.delete(deptno);
        return "redirect:/dept/list";
    }
}
