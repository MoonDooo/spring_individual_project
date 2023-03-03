package com.example.comment.repository;

import com.example.comment.domain.Member;

public interface MemberRepository {
    public void save(Member member);
    boolean existsByNickname(String nickname);
    boolean existsById(String id);

    Member findOneMember(String memberId);
}
