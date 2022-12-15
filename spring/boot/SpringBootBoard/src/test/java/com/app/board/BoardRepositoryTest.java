package com.app.board;

import com.app.board.entity.Board;
import com.app.board.entity.BoardRepository;
import com.app.board.entity.ReplyRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

@SpringBootTest
@Log4j2
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void jpaMethodTest(){
        /*Optional<Board> board = boardRepository.findById(116);
        Board boardData = board.orElse(null);

        log.info(board);*/


        // insert
        /*Board insertData = Board.builder()
                .title("jpa test")
                .content("jpa test")
                .writer("guest")
                .build();

        Board resultData = boardRepository.save(insertData);

        log.info(resultData);*/


        // 수정
        Board editData = Board.builder()
                .bno(121)
                .title("jpa update test")
                .content("jpa update test")
                .writer("guest")
                .build();
        Board editResult = boardRepository.save(editData);
        log.info(editResult);

    }

    @Test
    public void boardWithCntTest(){
        Page<Object[]> result = boardRepository.listWithCnt(PageRequest.of(0, 10, Sort.by("bno").descending()));

        log.info("result >>> 조회항목 리스트 " + result.getContent());     // [[], [], []]
        log.info("result >>> 전체 게시물의 개수 " + result.getTotalElements());
        log.info("result >>> 전체 페이지의 개수 " + result.getTotalPages());
        log.info("result >>> 현재 요청 페이지 " + result.getNumber()); // 0부터 시작!
        log.info("result >>> 페이지 당 표현할 항목의 개수 " + result.getSize());
        log.info("result >>> 현재 페이지에 출력된 항목의 개수 " + result.getNumberOfElements());

        for(Object[] arr : result.getContent()){
            log.info(Arrays.toString(arr));
        }
    }
}
