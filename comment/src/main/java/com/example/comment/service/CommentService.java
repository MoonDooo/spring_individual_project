package com.example.comment.service;

import com.example.comment.domain.Comment;
import com.example.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    @Autowired CommentRepository commentRepository;

    public void save(Comment comment){
        commentRepository.save(comment);
    }

    public List<Comment> getCommentWithMember(){
        return commentRepository.findAllCommentWithMember();
    }

    public List<Comment> getComment(){
        return commentRepository.findAllComment();
    }

}
