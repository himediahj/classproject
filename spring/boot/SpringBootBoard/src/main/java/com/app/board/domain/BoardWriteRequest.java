package com.app.board.domain;

import com.app.board.entity.Board;
import com.app.board.entity.BoardMember;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardWriteRequest {
    private String title;
    /*private String writer;*/  // 작성자 이름 문자열을 받았었다면 -> 이젠 작성자의 idx 값 필요
    private Integer writer;
    private String content;
    private MultipartFile formFile;

    /*public BoardDTO toBoardDTO(){
        return BoardDTO.builder()
                .title(title)
                .writer(writer)
                .content(content)
                .build();
    }*/

    public Board toBoardEntity(){
        return Board.builder()
                .title(title)
                .writer(BoardMember.builder().idx(writer).build())
                .content(content)
                .build();
    }
}
