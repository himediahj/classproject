package com.app.board.mapper;

import com.app.board.domain.BoardArticleDTO;
import com.app.board.domain.BoardDTO;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("select * from tbl_board")
    List<BoardDTO> selectAll();

    // @Select("select * from tbl_board order by bno desc limit #{param1},#{param2}")
    // List<BoardDTO> selectList(int start, int count);
    // (@Param("start) int start, @Param("count") int count) 쓰면 sql에 limit #{start},#{count} 식별자 쓸 수 있음

    @Select("select *, (select count(*) from tbl_reply r where r.bno=b.bno) as replycnt from tbl_board b order by bno desc limit #{param1},#{param2}")
    List<BoardArticleDTO> selectList(int start, int count);


    @Select("select count(*) from tbl_board")
    Integer totalCount();

    @Insert("insert into tbl_board (title, content, writer, photo) values (#{title}, #{content}, #{writer}, #{photo})")
    Integer insert(BoardDTO boardDTO) throws SQLException;

    // 게시글 하나의 정보
    @Select("select * from tbl_board where bno=#{bno}")
    BoardDTO selectByBno(int bno);

    @Delete("delete from tbl_board where bno=#{bno}") // 파라미터 하나라서 뭘 써도 상관x
    Integer deleteByBno(int bno);

    @Update("update tbl_board set title=#{title}, content=#{content}, writer=#{writer}, photo=#{photo}, updatedate=now() where bno=#{bno}")
    Integer update(BoardDTO boardDTO) throws SQLException;
}
