package com.app.board.service;

import com.app.board.domain.BoardDTO;
import com.app.board.entity.Board;
import com.app.board.repository.BoardRepository;
import com.app.board.mapper.BoardMapper;
import com.app.board.repository.ReplyRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@Log4j2
public class BoardDeleteService {
    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;


    public int delete(int bno){

        // 삭제하려는 게시물의 데이터
        // BoardDTO boardDTO = boardMapper.selectByBno(bno);
        Board board = boardRepository.findById(bno).get();

        // 먼저 모든 댓글을 삭제
        replyRepository.deleteByBno(bno);

        // 삭제 결과
        // int result = boardMapper.deleteByBno(bno);
        int result = boardRepository.deleteByBno(bno);

        // 해당 게시물이 DB에서 삭제되고 해당 게시물의 사진 이름을 가지고 있다면 파일 삭제
        if(result>0 && board.getPhoto() != null){
            File delFile = new File(new File("").getAbsolutePath(), "photo"+File.separator+board.getPhoto());    // separator = \\ 경로 분리 메소드, photo\\
            if(delFile.exists()){
                delFile.delete();
                log.info("파일 삭제 완료");
            }
        }

        return result;
    }
}
