package com.example.comment.dto.commentDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WriteCommentDTO {
    private String memberId;
    private String comment;
}
