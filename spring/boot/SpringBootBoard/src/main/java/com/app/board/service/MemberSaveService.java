package com.app.board.service;

import com.app.board.domain.MemberDTO;
import com.app.board.entity.BoardMember;
import com.app.board.repository.MemberJoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberSaveService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MemberJoinRepository memberJoinRepository;

    public int joinMember(MemberDTO memberDTO){
        int result = 0;
        BoardMember member = memberDTO.toMemberEntity();
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        member.setRole("USER");
        result = memberJoinRepository.save(member) != null ? 1 : 0;
        return result;
    }
}
