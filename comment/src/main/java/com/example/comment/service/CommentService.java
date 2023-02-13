package com.example.comment.service;

import com.example.comment.domain.Comment;
import com.example.comment.domain.Member;
import com.example.comment.repository.CommentRepository;
import com.example.comment.repository.MemberRepository;
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
    @Autowired MemberRepository memberRepository;

    public String save(String memberId, String comment){
        Member member = memberRepository.findOneMember(memberId);
        Comment commentDomain = new Comment(comment , member);
        commentRepository.save(commentDomain);
        return member.getNickname();
    }

    public List<Comment> getCommentWithMember(){
        return commentRepository.findAllCommentWithMember();
    }

    public List<Comment> getComment(){
        return commentRepository.findAllComment();
    }

    public List<Comment> getCommentWithMemberPage(int offset, int limit){
        return commentRepository.findAllCommentWithMemberPage(offset, limit);
    }
}
