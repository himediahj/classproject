/*
package com.spring.todolist.service;

import com.spring.todolist.dao.TodoDao;
import com.spring.todolist.domain.TodoDTO;
import com.spring.todolist.util.ConnectionProvider;
import lombok.Cleanup;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Service
public class TodoService {

    private final TodoDao dao;

    public TodoService(TodoDao dao) {
        this.dao = dao;
    }

    public List<TodoDTO> getTodoList(){
        List<TodoDTO> list = null;
        try {
            @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
            list = dao.selectAll(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public TodoDTO getTodoRead(long tno){
        TodoDTO todoDTO = null;
        try {
            @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
            todoDTO = dao.selectBy(conn, tno);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return todoDTO;
    }

    public int getTodoReg(TodoDTO todoDTO){
        int result = 0;
        try {
            @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
            result = dao.insert(conn, todoDTO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int getTodoModify(TodoDTO todoDTO){
        int result = 0;
        try {
            @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
            result = dao.update(conn, todoDTO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int getTodoRemove(long tno){
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
*/
