package com.example.comment.service;

import com.example.comment.domain.Member;
import com.example.comment.dto.memberDto.JoinMemberResponseDTO;

public interface MemberService{
    public String join(Member member);
    public JoinMemberResponseDTO joinAndResponseMemberIdToDto(Member member);
}
