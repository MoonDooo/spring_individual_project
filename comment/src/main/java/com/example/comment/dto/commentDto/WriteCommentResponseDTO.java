package com.example.comment.dto.commentDto;

import lombok.Data;

@Data
public class WriteCommentResponseDTO{
    String nickName;
    public WriteCommentResponseDTO(String nickName) {
        this.nickName = nickName;
    }
}