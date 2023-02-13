package com.example.comment.repository;

import com.example.comment.domain.Comment;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {
    @Autowired EntityManager em;

    /**
     * DB 저장
     */
    public Long save(Comment comment){
        em.persist(comment);
        return comment.getId();
    }

    /**
     * DB 접근
     */
    public List<Comment> findAllComment(){
        return em.createQuery("select m from Comment m", Comment.class)
                .getResultList();
    }

    public List<Comment> findAllCommentWithMember(){
        return em.createQuery("select m from Comment m INNER JOIN m.member", Comment.class)
                .getResultList();
    }

    public List<Comment> findAllCommentWithMemberPage(int offset, int limit) {
        return em.createQuery("select m from Comment m INNER JOIN m.member ORDER BY m.localDateTime DESC", Comment.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }
}
