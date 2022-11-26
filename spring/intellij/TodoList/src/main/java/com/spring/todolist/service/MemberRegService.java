package com.spring.todolist.service;

import com.spring.todolist.domain.Member;
import com.spring.todolist.domain.MemberRegRequest;
import com.spring.todolist.mapper.MemberMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
public class MemberRegService {

    @Autowired(required = false)
    private MemberMapper memberMapper;

    public int memberReg(MemberRegRequest regRequest, HttpServletRequest request) throws SQLException {

        String newFileName = null;

        // 파일 업로드 처리 여부 체크
        if(regRequest.getUphoto() != null && !regRequest.getUphoto().isEmpty() && regRequest.getUphoto().getSize()>0){
            // uri 정의 : 저장할 폴더
            String dirURI = "/uploadfile/member";

            // 시스템 절대 경로
            String dirRealPath = request.getSession().getServletContext().getRealPath(dirURI);
            //log.info(dirRealPath);

            newFileName = System.nanoTime() + regRequest.getUphoto().getOriginalFilename(); // 사진 이름 겹칠 수 있으니까

            // 저장
            try {
                regRequest.getUphoto().transferTo(new File(dirRealPath, newFileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Member member = regRequest.toMember();
        if(newFileName != null){
            member.setUphoto(newFileName);
        }
        //log.info(member);


        return memberMapper.insertMem(member);
    }

    // 회원가입 시 유효성 체크
    @Transactional(readOnly = true)
    public Map<String, String> validateHandling(Errors errors){
        Map<String, String> validatorResult = new HashMap<>();

        // 유효성 검사에 실패한 필드 목록 받음
        for(FieldError error : errors.getFieldErrors()){
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }
}
