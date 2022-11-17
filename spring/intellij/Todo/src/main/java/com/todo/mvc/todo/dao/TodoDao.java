package com.todo.mvc.todo.dao;

import com.todo.mvc.todo.dto.TodoDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface TodoDao {
    public int insert(Connection conn, String title, String dueDate) throws SQLException;

    public List<TodoDTO> selectAll(Connection conn) throws SQLException;

    public TodoDTO selectBy(Connection conn, long tno) throws SQLException;

    public int update(Connection conn, TodoDTO todoDTO) throws SQLException;

    public int delete(Connection conn, long tno) throws SQLException;
}
