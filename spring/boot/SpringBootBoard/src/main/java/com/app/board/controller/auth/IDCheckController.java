package com.app.board.controller.auth;

import com.app.board.service.auth.MemberSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth/idCheck")
public class IDCheckController {
    @Autowired
    private MemberSaveService memberSaveService;

    @PostMapping
    public ResponseEntity<Long> idCheck(@RequestParam("userid") String userid){
        return new ResponseEntity<>(memberSaveService.idCheck(userid), HttpStatus.OK);
    }
}