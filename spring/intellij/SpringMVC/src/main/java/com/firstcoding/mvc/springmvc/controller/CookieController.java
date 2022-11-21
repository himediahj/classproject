package com.firstcoding.mvc.springmvc.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@Controller
@RequestMapping("/cookie")
public class CookieController {

    @GetMapping("/view")
    public String viewCookie(@CookieValue("userName") String userName, @CookieValue(name = "auth", defaultValue = "ok") String auth, Model model,
                             @RequestHeader("Referer") String referer){
        // CookieValue도 required=true 라서 requestParam이랑 비슷 / 데이터가 없으면 defaultValue 설정해줘서 처리
        log.info("auth : " + auth);
        log.info("userName : " + userName);

        model.addAttribute("cookieName", "userName");
        model.addAttribute("cookieValue", userName);

        log.info("Referer : " + referer);   // 이전 페이지 주소를 가리킴 return redirect 쓸 때 사용
        return "cookie/view";
    }

    @GetMapping("/make")
    public String makeCookie(HttpServletResponse response){
        Cookie cookie = new Cookie("userName", "son");
        cookie.setPath("/");
        cookie.setMaxAge(60*60);

        response.addCookie(cookie);
        return "cookie/make";
    }
}
