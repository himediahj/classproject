package com.app.board.controller.emp;

import com.app.board.service.emp.EmpListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmpListController {
    @Autowired
    private EmpListService empListService;

    @GetMapping("/emp/list")
    public void getList(Model model, @RequestParam(value = "p", defaultValue = "1") int pageNum){
        model.addAttribute("listPage", empListService.getPage(pageNum));
    }
}
