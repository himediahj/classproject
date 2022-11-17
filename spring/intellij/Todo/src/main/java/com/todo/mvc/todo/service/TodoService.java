package com.todo.mvc.todo.service;

import com.todo.mvc.todo.dao.TodoDao;
import com.todo.mvc.todo.dao.TodoDaoImpl;
import com.todo.mvc.todo.dto.TodoDTO;
import com.todo.mvc.todo.util.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TodoService {
    private final TodoDao todoDao;

    private static TodoService instance = new TodoService();

    public TodoService(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public TodoService() {
        this.todoDao = new TodoDaoImpl();
    }

    public static TodoService getInstance(){
        return instance;
    }

    public List<TodoDTO> getTodoList() throws SQLException {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();
        List<TodoDTO> list = todoDao.selectAll(conn);
        return list;
    }
}
