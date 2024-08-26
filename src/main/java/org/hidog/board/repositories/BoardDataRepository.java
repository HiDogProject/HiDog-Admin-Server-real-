package org.hidog.board.repositories;

import org.hidog.board.entities.BoardData;
import org.hidog.member.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface BoardDataRepository extends JpaRepository<BoardData, Long>, QuerydslPredicateExecutor<BoardData> {
    BoardData findByLongText1(String longText1);

    @Query("SELECT COUNT(b) FROM BoardData b WHERE b.member.seq = :memberSeq")
    int countPostsByMember(@Param("memberSeq") Long memberSeq);

    List<BoardData> findByMember(Member member);

    Optional<BoardData> findBySeq(Long seq);
}
