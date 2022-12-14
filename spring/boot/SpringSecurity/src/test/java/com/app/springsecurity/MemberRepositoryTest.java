package com.app.springsecurity;

import com.app.springsecurity.entity.Member;
import com.app.springsecurity.entity.MemberRole;
import com.app.springsecurity.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertMemberTest(){
        Member member = Member.builder()
                .email("admin@gmail")
                .name("관리자-1")
                .roleSet(new HashSet<MemberRole>())
                .password(passwordEncoder.encode("1111"))
                .build();

        member.addMemberRole(MemberRole.ADMIN);

        memberRepository.save(member);
    }
}
