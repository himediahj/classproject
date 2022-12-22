package com.app.board.repository;

import com.app.board.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardTodoRepository extends JpaRepository<Todo, Integer> {
    @Query("select t from Todo t where t.writer.idx = ?1 order by t.dueDate")
    List<Todo> findByWriter_IdxOrderByDueDateAsc(Integer idx);

    @Transactional
    @Modifying
    @Query("delete from Todo t where t.tno = ?1")
    int deleteByTno(Integer tno);

    @Query("select t from Todo t where t.writer.idx = ?1 and t.finished = false order by t.dueDate")
    List<Todo> findByWriter_IdxAndFinishedFalseOrderByDueDateAsc(Integer idx);

    @Query("""
            select t from Todo t
            where upper(t.todo) like upper(concat('%', ?1, '%')) and t.writer.idx = ?2
            order by t.dueDate""")
    List<Todo> findByTodoContainsIgnoreCaseAndWriter_IdxOrderByDueDateAsc(String todo, Integer idx);








}
