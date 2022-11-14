package com.firstcoding.todo.service;

import com.firstcoding.todo.dao.TodoDao;
import com.firstcoding.todo.domain.TodoDTO;
import com.firstcoding.todo.util.ConnectionUtil;
import com.sun.tools.javac.comp.Todo;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class TodoService {
    private TodoService(){}
    private static TodoService instance = new TodoService();

    public static TodoService getInstance(){
        if(instance==null) instance = new TodoService();
        return instance;
    }
    private TodoDao dao = new TodoDao();

    public List<TodoDTO> getTodoList() throws Exception {

        log.info("TodoService getTodoList...");
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();
        List<TodoDTO> list = dao.selectAll(conn);
        return list;

    }

    public TodoDTO getTodoRead(long tno) throws Exception {
        log.info("TodoService getTodoRead...");
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();
        TodoDTO todo = dao.selectBy(conn, tno);
        return todo;
    }

    public int getTodoRegister(String title, String dueDate) throws Exception {
        log.info("TodoService getTodoRegister...");
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();
        int result = dao.insert(conn, title, dueDate);
        return result;
    }

    public int getTodoModify(TodoDTO todo) throws Exception {
        log.info("TodoService getTodoModify...");
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();
        int result = dao.update(conn, todo);
        return result;
    }

    public int getTodoRemove(long tno) throws Exception {
        log.info("TodoService getTodoRemove...");
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();
        int result = dao.delete(conn, tno);
        return result;
    }
}
