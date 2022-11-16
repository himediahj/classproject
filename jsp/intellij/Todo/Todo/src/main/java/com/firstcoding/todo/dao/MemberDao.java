package com.firstcoding.todo.dao;

import com.firstcoding.todo.domain.MemberDTO;

import java.sql.Connection;
import java.sql.SQLException;

public interface MemberDao {

    public int insertMem(Connection conn, MemberDTO memberDTO) throws SQLException;

    public MemberDTO searchByUidPw(Connection conn, String uid, String pw) throws SQLException;
}
