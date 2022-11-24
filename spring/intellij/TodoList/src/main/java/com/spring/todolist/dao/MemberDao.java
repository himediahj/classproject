package com.spring.todolist.dao;

import com.spring.todolist.domain.Member;

import java.sql.Connection;
import java.sql.SQLException;

public interface MemberDao {

    int insertMem(Connection conn, Member member) throws SQLException;

    Member selectByIdPw(Connection conn, String uid, String pw) throws SQLException;
}
