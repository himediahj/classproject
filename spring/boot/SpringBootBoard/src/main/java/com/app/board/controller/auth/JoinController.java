package com.app.board.controller.auth;

import com.app.board.domain.MemberDTO;
import com.app.board.domain.Message;
import com.app.board.service.auth.MemberSaveService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth/join")
@Log4j2
public class JoinController {
    @Autowired
    private MemberSaveService memberSaveService;

    @GetMapping
    public void joinForm(){}

    @PostMapping
    public String join(@Valid MemberDTO memberDTO, Errors errors){
        log.info(memberDTO);
        if(errors.hasErrors()){
            return "/auth/join";
        }
        memberSaveService.joinMember(memberDTO);
        return "redirect:/";
    }


}
