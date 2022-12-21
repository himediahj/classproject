package com.app.board.repository;

import com.app.board.entity.BoardMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJoinRepository extends JpaRepository<BoardMember, Integer> {
}
