package com.app.board.controller.emp;

import com.app.board.domain.emp.ReplyDTO;
import com.app.board.service.emp.EmpReplyListService;
import com.app.board.service.emp.EmpReplyInsertService;
import com.app.board.service.emp.EmpReplyReadService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp/reply")
@Log4j2
public class EmpReplyRestController {
    @Autowired
    private EmpReplyInsertService replyInsertService;

    @Autowired
    private EmpReplyReadService replyReadService;

    @Autowired
    private EmpReplyListService empReplyListService;


    @PostMapping
    public ResponseEntity<ReplyDTO> insertReply(@RequestBody ReplyDTO replyDTO){
        replyInsertService.insertReply(replyDTO);
        return new ResponseEntity<>(replyReadService.selectByRno(replyDTO.getRno()), HttpStatus.OK);
    }

    @GetMapping(value = "/{empno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReplyDTO>> selectList(@PathVariable("empno") int empno){
        List<ReplyDTO> list = empReplyListService.selectAll(empno);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
