package com.todo.todospring.controller;

import com.todo.todospring.domain.MemberRegRequest;
import com.todo.todospring.service.MemberRegService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
@RequestMapping("/member/register")
@Log4j2
public class MemberRegController {
    @Autowired
    private MemberRegService regService;

    @GetMapping
    public String getRegForm(){
        return "member/regForm";
    }

    @PostMapping
    public String reg(MemberRegRequest regRequest, HttpServletRequest request) throws SQLException {
        log.info(regRequest);
        log.info(regRequest.toMember());

        regService.memberReg(regRequest, request);
        return "redirect:/index.jsp";
    }
}
