package com.example.comment.repository;

import com.example.comment.domain.Comment;

import java.util.List;

public interface CommentRepository {
    public Long save(Comment comment);
    public List<Comment> findAllComment();
    public List<Comment> findAllCommentWithMember();
    public List<Comment> findAllCommentWithMemberPage(int offset, int limit);
}
