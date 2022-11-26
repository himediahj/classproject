package com.spring.todolist.controller;

import com.spring.todolist.domain.MemberRegRequest;
import com.spring.todolist.service.MemberRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.SQLException;
import java.util.Map;

@Controller
@RequestMapping("/member/register")
public class MemberRegController {
    @Autowired
    private MemberRegService memberRegService;

    @GetMapping
    public String getRegForm(){return "member/regForm";}

    @PostMapping
    public String reg(MemberRegRequest regRequest, HttpServletRequest request,
                      @Valid MemberRegRequest memberRegRequest, Errors errors, Model model) throws SQLException {

        if(errors.hasErrors()){
            // 회원가입 실패시 입력 데이터 값 유지
            model.addAttribute("memData",memberRegRequest);

            // 유효성 통과 못한 필드와 메시지를 핸들링
            Map<String, String> validatorResult = memberRegService.validateHandling(errors);
            for(String key : validatorResult.keySet()){
                model.addAttribute(key, validatorResult.get(key));
            }

            // 회원가입 페이지로 리턴
            return "member/regForm";
        }
        memberRegService.memberReg(regRequest, request);
        return "redirect:/login";
    }
}
