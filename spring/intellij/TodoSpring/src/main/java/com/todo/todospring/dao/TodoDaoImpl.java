package com.todo.todospring.dao;


import com.todo.todospring.domain.TodoDTO;
import lombok.Cleanup;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "todoDao")  // spring tab -> servlet context -> daoimpl에서 이름만 바꾼 것
public class TodoDaoImpl implements TodoDao {
    public List<TodoDTO> selectAll(Connection conn) throws SQLException {
        List<TodoDTO> list = new ArrayList<>();
        @Cleanup Statement stmt = conn.createStatement();
        String sql = "select * from todo";
        @Cleanup ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            list.add(rowTodo(rs));
        }

        return list;
    }

    public TodoDTO selectBy(Connection conn, long tno) throws SQLException {
        TodoDTO todo = null;
        String sql = "select * from todo where tno=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, tno);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        if(rs.next()) {
            todo = rowTodo(rs);
        }
        return todo;
    }

    private TodoDTO rowTodo(ResultSet rs) throws SQLException {
        return new TodoDTO(rs.getLong(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getBoolean(4));
    }

    public int insert(Connection conn, TodoDTO todo) throws SQLException {
        int result = 0;
        String sql = "insert into todo (title, dueDate) values (?, ?)";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, todo.getTitle());
        pstmt.setDate(2, Date.valueOf(todo.getDueDate()));

        result = pstmt.executeUpdate();
        return result;

    }

    public int update(Connection conn, TodoDTO todo) throws SQLException {
        int result = 0;
        String sql = "update todo set title=?, dueDate=?, finished=? where tno=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, todo.getTitle());
        pstmt.setDate(2, Date.valueOf(todo.getDueDate()));
        pstmt.setBoolean(3, todo.isFinished());
        pstmt.setLong(4, todo.getTno());

        result = pstmt.executeUpdate();
        return result;


    }

    public int delete(Connection conn, long tno) throws SQLException {
        int result = 0;
        String sql = "delete from todo where tno=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, tno);
        result = pstmt.executeUpdate();
        return result;
    }
}
