package com.spring.todolist.service;


import com.spring.todolist.domain.Member;
import com.spring.todolist.mapper.MemberMapper;
import com.spring.todolist.util.ConnectionProvider;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;

@Service
public class LoginService {
    @Autowired(required = false)
    private MemberMapper memberMapper;

    public Member login(String uid, String pw) {

        return memberMapper.selectByIdPw(uid, pw);
    }
}
