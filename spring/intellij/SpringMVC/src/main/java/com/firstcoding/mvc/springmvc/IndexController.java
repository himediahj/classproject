package com.firstcoding.mvc.springmvc;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class IndexController {
    @RequestMapping("/index")
    public void getIndex(){ // void일 때 url을 따서 "index" 반환 -> '/WEB-INF/views/index.jsp를 찾음
       log.info("Index page ...");
    }
}
