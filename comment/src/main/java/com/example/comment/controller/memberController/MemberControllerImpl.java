package com.example.comment.controller.memberController;

import com.example.comment.domain.Member;
import com.example.comment.dto.memberDto.CreateMemberRequestDTO;
import com.example.comment.dto.memberDto.JoinMemberResponseDTO;
import com.example.comment.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberControllerImpl implements MemberController{
    @Autowired private final MemberService memberService;
    @PostMapping("/new")
    public JoinMemberResponseDTO createMember(@RequestBody @Valid CreateMemberRequestDTO request){
        Member member = new Member(request.getId(), request.getPasswd(), request.getName(), request.getNickName());

        return memberService.joinAndResponseMemberIdToDto(member);
    }

}
