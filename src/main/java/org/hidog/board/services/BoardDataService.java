package org.hidog.board.services;

import org.hidog.board.entities.BoardData;
import org.hidog.member.entities.Member;
import org.hidog.member.services.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.hidog.board.repositories.BoardDataRepository;

import java.util.List;

@Service
public class BoardDataService {
    @Autowired
    private BoardDataRepository boardDataRepository;

    @Autowired
    private MemberInfoService memberInfoService;

    public List<BoardData> findPostsByMemberId(Long memberId) {
        // 회원 정보를 조회
        Member member = memberInfoService.findById(memberId);
        // 회원 정보를 기반으로 게시물 목록 조회
        return boardDataRepository.findByMember(member);
    }
    public BoardData findBySeq(Long seq) {
        return boardDataRepository.findBySeq(seq)
                .orElseThrow(() -> new RuntimeException("게시물이 존재하지 않습니다."));
    }
}