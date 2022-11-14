package com.firstcoding.todo.controller;

import com.firstcoding.todo.domain.TodoDTO;
import com.firstcoding.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoModifyController", value = "/todo/modify")
@Log4j2
public class TodoModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("modify get ...");

        TodoService service = TodoService.getInstance();
        TodoDTO todo = null;
        try {
            todo = service.getTodoRead(Long.parseLong(request.getParameter("tno")));
        } catch (Exception e) {

        }

        request.setAttribute("todo", todo);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/modify.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("modify post ...");

        // 사용자 입력한 데이터 모두 받기
        request.setCharacterEncoding("utf-8");

        TodoService service = TodoService.getInstance();

        String tno = request.getParameter("tno");
        String title = request.getParameter("title");
        String dueDate = request.getParameter("dueDate");
        String finished = request.getParameter("finished");


        // Service로 보낼 DTO 생성
        TodoDTO dto = new TodoDTO(Long.parseLong(tno), title, dueDate, finished == null ? false : true);

        // Service로 전송 -> 응답 int

        int result = 0;
        try {
            result = service.getTodoModify(dto);
        } catch (Exception e) {

        }

        response.sendRedirect("/todo/list");
    }
}
