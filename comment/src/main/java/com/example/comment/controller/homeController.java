package com.example.comment.controller;

import com.example.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class homeController {
    @Autowired
    CommentService commentService;

    @RequestMapping("/")
    public String createComment(){
        /**
         * 여기부터 다시 시작 -> 댓글 보이는 부분 작성
         */
        return "home";
    }
}
