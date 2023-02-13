package com.example.comment.controller;

import com.example.comment.domain.Member;
import com.example.comment.service.MemberService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/member/new")
    public CreateMemberResponse createMember(@RequestBody @Valid  CreateMemberRequest request){
        Member member = new Member(request.getId(), request.getPasswd(), request.getName(), request.getNickName());

        String id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @Data
    static class CreateMemberResponse{
        String id;
        public CreateMemberResponse(String name) {
            this.id = name;
        }
    }

    @Data
    static class CreateMemberRequest{
        private String id;
        private String passwd;
        private String name;
        private String nickName;

        public CreateMemberRequest(String id, String passwd, String name, String nickName) {
            this.id = id;
            this.passwd = passwd;
            this.name = name;
            this.nickName = nickName;
        }
    }

}
