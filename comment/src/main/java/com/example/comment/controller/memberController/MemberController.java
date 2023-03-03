package com.example.comment.controller.memberController;

import com.example.comment.dto.memberDto.CreateMemberRequestDTO;
import com.example.comment.dto.memberDto.JoinMemberResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

public interface MemberController {
    public JoinMemberResponseDTO createMember(CreateMemberRequestDTO request);
}
