package com.spring.todolist.controller;

import com.spring.todolist.domain.MemberRegRequest;
import com.spring.todolist.service.MemberRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
@RequestMapping("/member/register")
public class MemberRegController {
    @Autowired
    private MemberRegService memberRegService;

    @GetMapping
    public String getRegForm(){return "member/regForm";}

    @PostMapping
    public String reg(MemberRegRequest regRequest, HttpServletRequest request) throws SQLException {
        memberRegService.memberReg(regRequest, request);
        return "redirect:/index.jsp";
    }
}
