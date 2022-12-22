package com.app.board.controller.auth;

import com.app.board.domain.MemberDTO;
import com.app.board.service.auth.MemberSaveService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth/join")
@Log4j2
public class JoinController {
    @Autowired
    private MemberSaveService memberSaveService;

    @GetMapping
    public void joinForm(){}

    @PostMapping
    public String join(MemberDTO memberDTO){
        log.info(memberDTO);
        memberSaveService.joinMember(memberDTO);
        return "redirect:/index";
    }
}
