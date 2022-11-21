package com.firstcoding.todo.controller;

import com.firstcoding.todo.domain.MemberDTO;
import com.firstcoding.todo.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet(name = "LogInController", value = "/login")
@Log4j2
public class LogInController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("로그인 화면...");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/loginform.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String pw = request.getParameter("pw");
        String idremember = request.getParameter("idremember");
        String rememberMe = request.getHeader("rememberme");

        // idremember null이 아니면 userid를 쿠키에 저장
        if(idremember != null){
            Cookie c = new Cookie("reId", userid);
            c.setMaxAge(60*60*24*180);  // 6개월
            response.addCookie(c);
        } else {
            Cookie c = new Cookie("reId", userid);
            c.setMaxAge(0);
            response.addCookie(c);
        }

        HttpSession session = request.getSession();

        try {
            MemberDTO member = MemberService.getInstance().login(userid, pw);   // 로그인 처리

            if(member == null){
                response.sendRedirect("/login?error=nf");
                return;
            }

            // rememberMe 값이 on 이면 -> 회원 DB => uuid 업데이트
            if(rememberMe != null && rememberMe.equals("on")){

                UUID uuid = UUID.randomUUID();
                Cookie c1 = new Cookie("uuid", uuid.toString());
                c1.setMaxAge(60*60*24*30);
                c1.setPath("/");
                response.addCookie(c1);

                MemberService.getInstance().updateUUID(member.getIdx(), uuid.toString());
            }

            session.setAttribute("loginInfo", member.getUid());
            response.sendRedirect("/index.jsp");
        } catch (SQLException e) {
            response.sendRedirect("/login?error=e");
        }


    }
}
