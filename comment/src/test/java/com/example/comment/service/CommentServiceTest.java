package com.example.comment.service;

import com.example.comment.domain.Comment;
import com.example.comment.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest
class CommentServiceTest {
    @Autowired MemberService memberService;
    @Autowired CommentService commentService;

    @Test
    public void 코멘트_조회(){
        Member member = new Member("ruddhks99", "rud1024", "임경완", "MoonDooo");
        memberService.join(member);

        Comment comment = new Comment("테스트 테스트 테스트", member);
        commentService.save(comment);

        Assertions.assertThat(comment).isEqualTo(commentService.getComment().get(0));
    }
}