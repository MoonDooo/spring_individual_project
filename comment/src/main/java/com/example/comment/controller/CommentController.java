package com.example.comment.controller;


import com.example.comment.domain.Comment;
import com.example.comment.domain.Member;
import com.example.comment.service.CommentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final String offsetDefault = "0";
    private final String limitDefault = "100";

    /**
     * 작성 기능
     * @param comment : 작성한 댓글
     * @return Long : 작성한 댓글 db에 저장 후 작성자 id 반환
     */
    @PostMapping("/comment/new")
    public WriteCommentResponse writeComment(@RequestBody @Valid CommentController.WriteCommentDTO comment){
        String nickName = commentService.save(comment.getMemberId(), comment.getComment());
        return new WriteCommentResponse(nickName);
    }

    @Data
    static class WriteCommentResponse{
        String nickName;
        public WriteCommentResponse(String nickName) {
            this.nickName = nickName;
        }
    }


    /**
     * 작성 및 조회 기능
     * @param comment : 작성한 댓글
     * @return List<Comment> : 작성한 댓글 db에 저장한 후 첫 페이지 조회
     */
    @PostMapping("/comment/new/select")
    public Result WriteCommentWithSelect(
            @RequestBody @Valid CommentController.WriteCommentDTO comment,
            @RequestParam(value = "offset", defaultValue = offsetDefault) int offset,
            @RequestParam(value = "limit", defaultValue = limitDefault) int limit){
        commentService.save(comment.getMemberId(), comment.getComment());
        return Comments(offset, limit);
    }

    @Data
    @AllArgsConstructor
    static class WriteCommentDTO {
        private String memberId;
        private String comment;
    }

    @GetMapping("/comment")
    public Result Comments(
            @RequestParam(value = "offset", defaultValue = offsetDefault) int offset,
            @RequestParam(value = "limit", defaultValue = limitDefault) int limit
            ){
        List<Comment> comments = commentService.getCommentWithMemberPage(offset, limit);
        List<CommentGetDTO> commentsDTOs = comments.stream()
                .map(CommentGetDTO::new)
                .collect(Collectors.toList());
        return new Result(commentsDTOs);
    }

    @Data
    @AllArgsConstructor
    class Result<T>{
        private T data;
    }

    @Data
    @RequiredArgsConstructor
    class CommentGetDTO{

        private String comment;
        private MemberGetDTO member;
        private LocalDateTime localDateTime;
        public CommentGetDTO(Comment comment) {
            this.comment = comment.getComment();
            this.localDateTime = comment.getLocalDateTime();

            member = new MemberGetDTO(comment.getMember());
        }
    }

    @Data
    @RequiredArgsConstructor
    public class MemberGetDTO {
        private String nickname;

        public MemberGetDTO(Member member) {
            this.nickname = member.getNickname();
        }
    }
}





















