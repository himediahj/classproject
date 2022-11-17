package com.firstcoding.mvc.springmvc.controller;

import com.firstcoding.mvc.springmvc.domain.LoginRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/login")
@Log4j2
public class LoginController {
    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String getLoginForm(Model model){
        model.addAttribute("msg", "아이디와 패스워드를 반드시 입력하세요");
        return "login/form";    // /WEB-INF/views/login/form.jsp
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public String Login(String uid, String pw, String p, // @RequestParam(value = "p", required = true) String page -> 파라미터 p가 필수로 있어야하니까 에러 페이지 뜸!
                        @RequestParam(value = "p", defaultValue = "1") String page, // list?pageNo=1 로 default 설정할 때 사용
                        HttpServletRequest request,
                        HttpServletResponse response,
                        @ModelAttribute("req") LoginRequest loginRequest,   // 많은 파라미터를 한번에 받을 수 있다, 여러 형태로 받아올 수 있음
                        @RequestParam Map paramMap){    // 문자열 String으로만 받는다
        log.info("uid => " + uid);
        log.info("pw => " + pw);
        log.info("p => " + p);  // null
        log.info("p => " + page);   // 1

        String uId2 = request.getParameter("uid");
        String pw2 = request.getParameter("pw");

        log.info("uId2 => " + uId2);
        log.info("pw2 => " + pw2);

        log.info("loginRequest => " + loginRequest);    // LoginRequest(uid=cool, pw=123456789)

        log.info("paramMap => " + paramMap);    // {uid=cool, pw=123456789}

        return "login/login";
    }

    @GetMapping("/info")    // http://localhost:8080/login/info
    public String info(){
        return "login/info";
    }
}
