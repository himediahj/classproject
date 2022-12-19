package com.app.board.security;

import com.app.board.entity.BoardMember;
import com.app.board.repository.BoardMemberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private BoardMemberRepository boardMemberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info(" >>>>>>>>> loadUserByUsername => " + username);   // 사용자가 입력한 id
        Optional<BoardMember> result = boardMemberRepository.findByUserid(username);

        if(result.isEmpty()) throw new UsernameNotFoundException("회원의 아이디 또는 비밀번호 확인");

        // 회원의 정보, 권한 정보 => CustomUser 인스턴스 생성하고 반환
        BoardMember member = result.get();
        log.info(" >>>>>> member => " + member);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+member.getRole()));

        CustomUser user = new CustomUser(member.getUserid(), member.getPassword(), authorities, member);

        return user;
    }
}
