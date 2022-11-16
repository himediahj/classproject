package com.firstcoding.todo.service;

import com.firstcoding.todo.dao.MemberDao;
import com.firstcoding.todo.dao.MemberDaoImpl;
import com.firstcoding.todo.domain.MemberDTO;
import com.firstcoding.todo.util.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.SQLException;

public class MemberService {

    private final MemberDao dao;

    private static MemberService instance = new MemberService();

    public MemberService(MemberDao dao) {
        this.dao = dao;
    }

    public MemberService() {
        this.dao = new MemberDaoImpl();
    }

    public static MemberService getInstance(){
        return instance;
    }

    public int insertMem(MemberDTO member) throws SQLException {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();
        return dao.insertMem(conn, member);
    }

    public MemberDTO login(String uid, String pw) throws SQLException {
        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();
        return dao.searchByUidPw(conn, uid, pw);
    }
}
