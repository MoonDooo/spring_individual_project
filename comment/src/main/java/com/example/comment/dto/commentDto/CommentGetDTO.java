package com.example.comment.dto.commentDto;

import com.example.comment.controller.commentController.CommentControllerImpl;
import com.example.comment.domain.Comment;
import com.example.comment.dto.memberDto.MemberGetDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class CommentGetDTO {

    private String comment;
    private MemberGetDTO memberDto;
    private LocalDateTime localDateTime;
    public CommentGetDTO(Comment comment) {
        this.comment = comment.getComment();
        this.localDateTime = comment.getLocalDateTime();

        memberDto = new MemberGetDTO(comment.getMember());
    }
}