package com.firstcoding.firstapp.calc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InputController", value = "/calc/input")
public class InputController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Calc InputController : doGet()");

        //Controller (Servlet) -> Model (Service -> Dao)
        // Model -> Controller : 데이터 반환

        // 결과 데이터
        String result = "계산기";   // Model 을 통한 결과 Data

        // view 페이지에 결과 데이터 전달 (공유)
        request.setAttribute("title", result);
        
        // view 지정
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/calc/input.jsp");
        // forward : request 객체 공유!!!
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 사용자가 입력한 데이터 받기
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");

        // 핵심처리
        int result = Integer.parseInt(num1) + Integer.parseInt(num2);

        request.setAttribute("num1", num1);
        request.setAttribute("num2", num2);
        request.setAttribute("result", result);


        // 결과 view 생성 처리
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/calc/result.jsp");
        dispatcher.forward(request, response);
    }
}
