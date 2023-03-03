package com.example.comment.dto.memberDto;

import com.example.comment.domain.Member;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MemberGetDTO {
    private String nickname;

    public MemberGetDTO(Member member) {
        this.nickname = member.getNickname();
    }
}