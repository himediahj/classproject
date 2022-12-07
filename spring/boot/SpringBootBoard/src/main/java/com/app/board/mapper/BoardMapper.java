package com.app.board.mapper;

import com.app.board.domain.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("select * from tbl_board")
    List<BoardDTO> selectAll();
    @Select("select * from tbl_board order by bno desc limit #{param1},#{param2}")
    List<BoardDTO> selectList(int start, int count);
    // (@Param("start) int start, @Param("count") int count) 쓰면 sql에 limit #{start},#{count} 식별자 쓸 수 있음

    @Select("select count(*) from tbl_board")
    Integer totalCount();
}
