package com.firstcoding.mvc.springmvc.exception;

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
    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public String exceptionNumber(NumberFormatException exception){ // http://localhost:8080/sample5?num=aaa 들어갔을 때
        log.info(exception.getMessage());
        return "NumberFormatException ...";
    }

/*    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public String exceptionNull(NullPointerException exception){
        log.info(exception.getMessage());
        return "NullPointerException ...";
    }*/

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exception(Exception exception){
        log.info(exception.getMessage());

        StackTraceElement[] stackTraceElements = exception.getStackTrace();
        StringBuffer buffer = new StringBuffer("<h1>");
        buffer.append(exception.getMessage() + "</h1>");
        buffer.append("<hr>");

        for(StackTraceElement element : stackTraceElements){
            buffer.append("<div>" + element + "</div>");
        }

        return buffer.toString();
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)   // 안만들어진 페이지 접속했을 때 공용으로 뜨게하는 페이지 만들기
    public String notFound(){   // web.xml 추가 설정 필요
        return "custom404";
    }
}
