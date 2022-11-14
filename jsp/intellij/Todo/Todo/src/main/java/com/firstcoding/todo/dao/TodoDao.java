package com.firstcoding.todo.dao;

import com.firstcoding.todo.domain.TodoDTO;
import lombok.Cleanup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {
    public List<TodoDTO> selectAll(Connection conn) throws SQLException {
        List<TodoDTO> list = new ArrayList<>();
        @Cleanup Statement stmt = conn.createStatement();
        String sql = "select * from todo";
        @Cleanup ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            list.add(new TodoDTO(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
        }

        return list;
    }

    public TodoDTO selectBy(Connection conn, long tno) throws SQLException {
        TodoDTO todo = null;
        String sql = "select * from todo where tno=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, tno);
        ResultSet rs = pstmt.executeQuery();

        if(rs.next()) {
            todo = new TodoDTO(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
        }
        return todo;
    }

    public int insert(Connection conn, String title, String dueDate) throws SQLException {
        int result = 0;
        String sql = "insert into todo (title, dueDate) values (?, ?)";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, title);
        pstmt.setString(2, dueDate);

        result = pstmt.executeUpdate();
        return result;

    }

    public int update(Connection conn, TodoDTO todo) throws SQLException {
        int result = 0;
        String sql = "update todo set title=?, dueDate=?, finished=? where tno=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, todo.getTitle());
        pstmt.setString(2, todo.getDueDate());
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
