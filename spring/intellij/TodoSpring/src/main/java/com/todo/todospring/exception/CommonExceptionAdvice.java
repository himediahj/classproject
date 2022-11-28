package com.todo.todospring.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {

    @ExceptionHandler(Exception.class)  // 모든 예외
    @ResponseBody
    public String except(Exception exception){
        log.info(exception.getMessage());
        return exception.getMessage();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(){
        log.info("notFound Handler 진입 ... ");
        return "error/404error"; // views의 경로 지정
    }
}
