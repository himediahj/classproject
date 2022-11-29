package com.todo.todospring.service;

import com.todo.todospring.domain.Member;
import com.todo.todospring.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class LoginService {
    @Autowired(required = false)
    private MemberMapper memberMapper;

    public Member login(String uid, String pw) throws SQLException {
        return memberMapper.selectByIdPw(uid, pw);
    }
}
