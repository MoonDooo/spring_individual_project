package com.example.comment.controller.commentController;


import com.example.comment.dto.Result;
import com.example.comment.dto.commentDto.RequestCommentSaveDTO;
import com.example.comment.dto.commentDto.WriteCommentResponseDTO;
import com.example.comment.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentControllerImpl implements CommentController{
    @Autowired private final CommentService commentService;
    private final String offsetDefault = "0";
    private final String limitDefault = "100";

    /**
     * 작성 기능
     * @param comment : 작성한 댓글
     * @return Long : 작성한 댓글 db에 저장 후 작성자 id 반환
     */
    @Override
    @PostMapping("new")
    public WriteCommentResponseDTO writeCommentResponse(@RequestBody @Valid RequestCommentSaveDTO comment) {
        String nickName = commentService.save(comment);
        return new WriteCommentResponseDTO(nickName);
    }


    /**
     * 작성 및 조회 기능
     * @param comment : 작성한 댓글
     * @return List<Comment> : 작성한 댓글 db에 저장한 후 첫 페이지 조회
     */
    @Override
    @PostMapping("new/select")
    public Result writeCommentWithSelect(
            @RequestBody @Valid RequestCommentSaveDTO comment,
            @RequestParam(value = "offset", defaultValue = offsetDefault) int offset,
            @RequestParam(value = "limit", defaultValue = limitDefault) int limit
    ) {
        commentService.save(comment);
        return Comments(offset, limit);
    }

    @Override
    @GetMapping
    public Result Comments(
            @RequestParam(value = "offset", defaultValue = offsetDefault) int offset,
            @RequestParam(value = "limit", defaultValue = limitDefault) int limit
            ){
        return new Result(commentService.getCommentsAsDto(offset, limit));
    }





}





















