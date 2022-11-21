package com.firstcoding.mvc.springmvc.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
public class PathVarController {
    // localhost:8080/member/1 or 11 or 30 ...
    @RequestMapping("/members/{type}/{idx}")    // 경로 특정 위치 값이 고정되지 않고 달라질 때 사용하는 것이 @PathVariable
    public String getMemberInfo(@PathVariable("type") String type, @PathVariable("idx") String idx, Model model){
        log.info("type : " + type);
        log.info("idx : " + idx);
        model.addAttribute("type", type);
        model.addAttribute("idx", idx);
        return "info";
    }
}
