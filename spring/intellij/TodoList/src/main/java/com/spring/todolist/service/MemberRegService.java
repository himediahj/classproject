package com.spring.todolist.service;

import com.spring.todolist.dao.MemberDao;
import com.spring.todolist.domain.Member;
import com.spring.todolist.domain.MemberRegRequest;
import com.spring.todolist.util.ConnectionProvider;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@Service
@Log4j2
public class MemberRegService {
    @Autowired
    private MemberDao memberDao;

    public int memberReg(MemberRegRequest regRequest, HttpServletRequest request) throws SQLException {

        String newFileName = null;

        // 파일 업로드 처리 여부 체크
        if(regRequest.getUphoto() != null && !regRequest.getUphoto().isEmpty() && regRequest.getUphoto().getSize()>0){
            // uri 정의 : 저장할 폴더
            String dirURI = "/uploadfile/member";

            // 시스템 절대 경로
            String dirRealPath = request.getSession().getServletContext().getRealPath(dirURI);
            log.info(dirRealPath);

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
        log.info(member);

        @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
        return memberDao.insertMem(conn, member);
    }
}
