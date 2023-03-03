package com.example.comment.dto.memberDto;

import lombok.Data;

@Data
public class JoinMemberResponseDTO {
    String id;
    public JoinMemberResponseDTO(String id) {
        this.id = id;
    }
}
