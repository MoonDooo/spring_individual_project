package com.example.comment;

import com.example.comment.domain.Comment;
import com.example.comment.domain.Member;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * db 초기화하는 곳
 */
@Component
@RequiredArgsConstructor
public class InitDB {
    private final InitService initService;

    @PostConstruct
    public void init(){
        //initService.init1();
    }

    @Transactional
    @Component
    @RequiredArgsConstructor
    static class InitService{
        private final EntityManager em;

        public void init1(){
            Member member = new Member("ruddhks99", "rud1024", "임경완", "MoonDooo");
            em.persist(member);

            Comment comment = new Comment("hello world!", member);
            em.persist(comment);
        }
    }
}
