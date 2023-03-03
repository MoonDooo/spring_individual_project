package com.example.comment.service;

import com.example.comment.domain.Member;
import com.example.comment.repository.MemberRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberServiceTest {
    @Autowired
    MemberRepositoryImpl memberRepository;
    @Autowired
    MemberServiceImpl memberService;

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member1 = new Member("ruddhks", "rud1024", "임경완", "MoonDooo");

        //when
        memberService.join(member1);

        //then
        assertThat(member1).isEqualTo(memberRepository.findOneMember("ruddhks"));
     }

     @Test
     public void 중복_닉네임_테스트() throws Exception {
         //given
         Member member1 = new Member("ruddhks", "rud1024", "임경완", "MoonDooo");
         Member member2 = new Member("ruddhks", "rud1024", "임경완", "MoonDooo");
         //when
         memberService.join(member1);
         //then
         assertThrows(IllegalStateException.class, ()->{
             memberService.join(member2);
         });
      }
}