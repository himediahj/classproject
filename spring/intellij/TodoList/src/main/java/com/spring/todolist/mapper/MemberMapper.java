package com.spring.todolist.mapper;

import com.spring.todolist.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {

    int insertMem(Member member);

    Member selectByIdPw(@Param("uid") String uid, @Param("pw") String pw);
}
