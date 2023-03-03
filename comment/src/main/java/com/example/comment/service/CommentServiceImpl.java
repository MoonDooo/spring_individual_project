package com.example.comment.service;

import com.example.comment.domain.Comment;
import com.example.comment.domain.Member;
import com.example.comment.dto.commentDto.CommentGetDTO;
import com.example.comment.dto.commentDto.RequestCommentSaveDTO;
import com.example.comment.repository.CommentRepository;
import com.example.comment.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService{
    @Autowired private final CommentRepository commentRepository;
    @Autowired private final MemberRepository memberRepository;


    public String save(RequestCommentSaveDTO commentDto){
        Member member = memberRepository.findOneMember(commentDto.getMemberId());
        Comment comment = new Comment(commentDto.getComment() , member);
        commentRepository.save(comment);
        return member.getNickname();
    }

    public Optional<List<Comment>> getCommentWithMember(){
        return Optional.ofNullable(commentRepository.findAllCommentWithMember());
    }

    public List<Comment> getComment(){
        return commentRepository.findAllComment();
    }

    public List<Comment> getCommentWithMembersByPage(int offset, int limit){
        return commentRepository.findAllCommentWithMemberPage(offset, limit);
    }

    public List<CommentGetDTO> getCommentsAsDto(int offset, int limit){
        log.info("offset={} , limit={}", offset, limit);
        List<Comment> commentWithMembersByPage = getCommentWithMembersByPage(offset, limit);
        List<CommentGetDTO> commentGetDTO = commentWithMembersByPage.stream()
                .map(CommentGetDTO::new)
                .collect(Collectors.toList());

        return commentGetDTO;
    }
}
