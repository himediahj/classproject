package com.firstcoding.mvc.springmvc.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j2
public class AuthCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info(" >>>>>>>>> 회원 로그인 여부 체크 ...");
        // 회원 로그인 상태 체크
        HttpSession session = request.getSession(false);

        // 회원이 로그인 상태이다?
        if(session != null && session.getAttribute("loginInfo") != null){
            log.info("로그인 상태 ...");
            return true;
        }

        log.info("비로그인 상태 ...");
        response.sendRedirect("/login");
        return false;
    }
}
