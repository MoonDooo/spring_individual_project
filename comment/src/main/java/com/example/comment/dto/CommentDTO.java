package com.example.comment.dto;

import com.example.comment.domain.Comment;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CommentDTO {
    Long id;

    @NotEmpty(message = "댓글이 비어있습니다.")
    String comment;
}
