package com.example.comment.service;

import com.example.comment.domain.Comment;
import com.example.comment.dto.commentDto.CommentGetDTO;
import com.example.comment.dto.commentDto.RequestCommentSaveDTO;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    public String save(RequestCommentSaveDTO commentDto);
    public Optional<List<Comment>> getCommentWithMember();
    public List<Comment> getComment();
    public List<Comment> getCommentWithMembersByPage(int offset, int limit);
    public List<CommentGetDTO> getCommentsAsDto(int offset, int limit);
}
