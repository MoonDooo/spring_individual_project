package com.example.comment.service;

import com.example.comment.domain.Member;
import com.example.comment.dto.memberDto.JoinMemberResponseDTO;
import com.example.comment.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    @Autowired
    private final MemberRepository memberRepository;

    public String join(Member member){
        if(memberRepository.existsByNickname(member.getNickname())){
            throw new IllegalStateException("이미 존재하는 닉네임입니다.");
        }
        if(memberRepository.existsById(member.getId())){
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
        memberRepository.save(member);

        return member.getId();
    }

    public JoinMemberResponseDTO joinAndResponseMemberIdToDto(Member member){
        return new JoinMemberResponseDTO(join(member));
    }
}
