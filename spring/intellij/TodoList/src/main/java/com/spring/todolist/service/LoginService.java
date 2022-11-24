package com.spring.todolist.service;

import com.spring.todolist.dao.MemberDao;
import com.spring.todolist.domain.Member;
import com.spring.todolist.util.ConnectionProvider;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;

@Service
public class LoginService {
    @Autowired
    private MemberDao memberDao;

    public Member login(String uid, String pw) throws SQLException {
        @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
        return memberDao.selectByIdPw(conn, uid, pw);
    }
}
