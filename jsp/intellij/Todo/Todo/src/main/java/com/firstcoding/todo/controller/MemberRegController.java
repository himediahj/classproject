package com.firstcoding.todo.controller;

import com.firstcoding.todo.domain.MemberDTO;
import com.firstcoding.todo.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "MemberRegController", value = "/member/register")
@Log4j2
public class MemberRegController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("회원 가입 폼...");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/regform.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("회원 가입 처리...");

        String uid = request.getParameter("uid");
        String pw = request.getParameter("pw");

        MemberDTO member = MemberDTO.builder()
                .uid(uid)
                .pw(pw)
                .build();

        int result = 0;
        try {
            result = MemberService.getInstance().insertMem(member);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(result>0){
            log.info("회원 가입 성공...");
        }

        response.sendRedirect("/index.jsp");
    }
}
