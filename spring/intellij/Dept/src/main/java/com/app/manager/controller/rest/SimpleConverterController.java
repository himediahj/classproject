package com.app.manager.controller.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mc/simple")
@Log4j2
public class SimpleConverterController {
    @GetMapping
    public void form(){
       log.info("form ...");
    }
    @PostMapping
    @ResponseBody
    public String simple(@RequestBody String body){
        log.info("body >>>>>>>> " + body);
        return "body >>>>>>>> " + body; // ResponseBody 없으면 jsp 경로를 찾을텐데 body 안에 있는 입력데이터 name=song&age=20 값을 다 가져옴
        // json 형식의 문자열을 가져올 수 있음!
    }

}
