package com.example.comment.controller.commentController;

import com.example.comment.dto.Result;
import com.example.comment.dto.commentDto.RequestCommentSaveDTO;
import com.example.comment.dto.commentDto.WriteCommentResponseDTO;

public interface CommentController {
    WriteCommentResponseDTO writeCommentResponse(RequestCommentSaveDTO writeCommentDTO);
    public Result writeCommentWithSelect(RequestCommentSaveDTO comment, int offset, int limit);
    public Result Comments(int offset, int limit);
}
