package com.app.board.service;

import com.app.board.domain.BoardDTO;
import com.app.board.domain.BoardWriteRequest;
import com.app.board.entity.Board;
import com.app.board.repository.BoardRepository;
import com.app.board.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@Service
@Log4j2
public class BoardWriteService {
    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private BoardRepository boardRepository;

    public int write(BoardWriteRequest boardWriteRequest){

        MultipartFile file = boardWriteRequest.getFormFile();

        File saveDir = null;
        String newFileName = null;

        if(file != null && !file.isEmpty() && file.getSize()>0){
            // String~try 구문 마지막에 if 안에 넣어줬어
            String absolutePath = new File("").getAbsolutePath();
            log.info(" >>> " + absolutePath);

            String path = "photo";
            saveDir = new File(absolutePath, path);

            // 폴더가 존재하지 않으면 생성
            if(!saveDir.exists()){
                saveDir.mkdir();    // 폴더 생성
                log.info(" >>> photo directory 생성");
            }

            String uuid = UUID.randomUUID().toString();
            // 새로운 파일 이름 생성
            newFileName = uuid + file.getOriginalFilename();

            // MultipartFile file = boardWriteRequest.getFormFile();

            // 새로운 저장 파일의 경로
            File newFile = new File(saveDir, newFileName);


            try {
                // 파일 저장
                file.transferTo(newFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // BoardDTO boardDTO = boardWriteRequest.toBoardDTO();
        // request -> entity로 변경
        Board board = boardWriteRequest.toBoardEntity();

        if(newFileName != null){
            board.setPhoto(newFileName);
        }

        int result = 0;

        try {
            // DB insert
            // result = boardMapper.insert(boardDTO);
            result = boardRepository.save(board) != null ? 1 : 0;
        } catch(Exception e){
            // 저장 됐는데 오류가 났으면 삭제해줘야함
            if(newFileName != null){
                File delFile = new File(saveDir, newFileName);
                if(delFile.exists()){
                    // 파일 삭제
                    delFile.delete();
                }
            }
        }
        return result;
    }
}
