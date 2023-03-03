package com.example.comment.controller.commentController;

import com.example.comment.dto.Result;
import com.example.comment.dto.commentDto.WriteCommentDTO;
import com.example.comment.dto.commentDto.WriteCommentResponseDTO;

public interface CommentController {
    WriteCommentResponseDTO writeCommentResponse(WriteCommentDTO writeCommentDTO);
    public Result writeCommentWithSelect(WriteCommentDTO comment, int offset, int limit);
    public Result Comments(int offset, int limit);
}
