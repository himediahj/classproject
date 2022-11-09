package com.firstcoding.firstapp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignupServlet", value = "/signup")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 사용자 입력값 한글처리
        request.setCharacterEncoding("utf-8");

        String email = request.getParameter("email");
        String pw = request.getParameter("pw");
        String userName = request.getParameter("username");
        String memo = request.getParameter("memo");
        String gender = request.getParameter("gender");
        // String lang = request.getParameter("lang");  한개만 가져오니까
        String[] langs = request.getParameterValues("lang");
        String year = request.getParameter("year");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.write("<html>");
        out.write("<head><meta charset=\"utf-8\"><title>가입 데이터</title></head>");
        out.write("<body>");
        out.write("<h1> email : " + email + "</h1>");
        out.write("<h1> pw : " + pw + "</h1>");
        out.write("<h1> name : " + userName + "</h1>");
        out.write("<h1> memo : " + memo + "</h1>");
        out.write("<h1> 성별 : " + gender + "</h1>");

        if(langs != null){
            for(String lang : langs){
                out.write("<h1> 언어 선택 : " + lang + "</h1>");
            }
        }

        out.write("<h1> 선택 년도 : " + year + "</h1>");

        out.write("</body>");
        out.write("</html>");
    }
}
