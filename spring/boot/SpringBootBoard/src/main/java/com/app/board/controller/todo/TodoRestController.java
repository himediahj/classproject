package com.app.board.controller.todo;

import com.app.board.domain.todo.TodoDTO;
import com.app.board.entity.Todo;
import com.app.board.security.CustomUser;
import com.app.board.service.todo.TodoDeleteService;
import com.app.board.service.todo.TodoEditService;
import com.app.board.service.todo.TodoInsertService;
import com.app.board.service.todo.TodoListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
@Log4j2
public class TodoRestController {
    @Autowired
    private TodoInsertService todoInsertService;

    @Autowired
    private TodoDeleteService todoDeleteService;

    @Autowired
    private TodoEditService todoEditService;

    @Autowired
    private TodoListService todoListService;

    @PostMapping
    public ResponseEntity<Todo> insertTodo(@RequestBody TodoDTO todoDTO){
        log.info("insert 전 : " + todoDTO);
        Todo todoresult = todoInsertService.insertTodo(todoDTO);
        log.info("insert 후 : " + todoresult);
        return new ResponseEntity<>(todoresult, HttpStatus.OK);
    }

    @DeleteMapping("/{tno}")
    public ResponseEntity<Integer> delete(@PathVariable("tno") int tno){
        return new ResponseEntity<>(todoDeleteService.deleteTodo(tno), HttpStatus.OK);
    }

    @PutMapping("/{tno}")
    public ResponseEntity<Integer> edit(@PathVariable("tno") int tno, @RequestBody TodoDTO todoDTO){
        todoDTO.setTno(tno);
        return new ResponseEntity<>(todoEditService.updateTodo(todoDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getList(@AuthenticationPrincipal CustomUser customUser){
        List<Todo> list = todoListService.selectAll(customUser.getBoardMember().getIdx());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/active")
    public ResponseEntity<List<Todo>> getActiveList(@AuthenticationPrincipal CustomUser customUser){
        List<Todo> list = todoListService.selectActive(customUser.getBoardMember().getIdx());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
