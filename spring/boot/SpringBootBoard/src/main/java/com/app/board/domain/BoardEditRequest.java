package com.app.board.domain;

import com.app.board.entity.Board;
import com.app.board.entity.BoardMember;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardEditRequest {
    private int bno;
    private int curPageNum;
    private String title;
//    private String writer;
    private Integer writer;
    private String content;
    private String oldFile;
    private MultipartFile formFile;

    /*public BoardDTO toBoardDTO(){
        return BoardDTO.builder()
                .bno(bno)
                .title(title)
                .writer(writer)
                .content(content)
                .photo(oldFile)
                .build();
    }*/

    public Board toBoardEntity(){
        return Board.builder()
                .bno(bno)
                .title(title)
                .writer(BoardMember.builder().idx(writer).build())
                .content(content)
                .photo(oldFile)
                .build();
    }
}
