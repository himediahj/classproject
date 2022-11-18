package com.todo.todospring.service;

import com.todo.todospring.dao.TodoDao;
import com.todo.todospring.domain.TodoDTO;
import com.todo.todospring.util.ConnectionProvider;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
@Service
@Log4j2
public class TodoService {

    private final TodoDao dao;  //@autuwired 써도 됨

    public TodoService(TodoDao dao) {
        this.dao = dao;
    }

    public List<TodoDTO> getTodoList() {

        log.info("TodoService getTodoList...");
        List<TodoDTO> list = null;
        try {
            @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
             list = dao.selectAll(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;

    }

    public TodoDTO getTodoRead(long tno) {
        log.info("TodoService getTodoRead...");
        TodoDTO todo = null;
        try {
            @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
            todo = dao.selectBy(conn, tno);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return todo;
    }

    public int getTodoRegister(TodoDTO todo) {
        log.info("TodoService getTodoRegister...");
        int result = 0;
        try {
            @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
            result = dao.insert(conn, todo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public int getTodoModify(TodoDTO todo) {
        log.info("TodoService getTodoModify...");
        int result = 0;
        try {
            @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
            result = dao.update(conn, todo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public int getTodoRemove(long tno) {
        log.info("TodoService getTodoRemove...");
        int result = 0;
        try {
            @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
            result = dao.delete(conn, tno);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
