package com.app.board.repository;

import com.app.board.entity.BoardMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberJoinRepository extends JpaRepository<BoardMember, Integer> {
    @Query("select count(b) from BoardMember b where b.userid = ?1")
    long countByUserid(String userid);
}
