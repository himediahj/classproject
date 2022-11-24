package com.spring.todolist.controller;

import com.spring.todolist.domain.Member;
import com.spring.todolist.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping
    public String loginForm(){return "loginForm";}

    @PostMapping
    public String login(@RequestParam("uid") String uid, @RequestParam("pw") String pw, HttpServletRequest request) throws SQLException {
        Member member = loginService.login(uid, pw);

        if(member != null){
            HttpSession session = request.getSession();
            session.setAttribute("loginInfo", member.toLoginInfo());
        }
        return "redirect:/index.jsp";
    }

}
