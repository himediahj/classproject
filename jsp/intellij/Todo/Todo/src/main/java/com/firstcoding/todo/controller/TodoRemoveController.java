package com.firstcoding.todo.controller;

import com.firstcoding.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoRemoveController", value = "/todo/remove")
@Log4j2
public class TodoRemoveController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("todo remove ...");

        TodoService service = new TodoService();
        // 삭제하고자 하는 todo의 tno 값을 받는다
        int result = 0;
        try {
            result = service.getTodoRemove(Long.parseLong(request.getParameter("tno")));
        } catch (Exception e) {

        }

        response.sendRedirect("/todo/list");
    }
}
