package com.example.comment.repository;


import com.example.comment.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository{
    @Autowired
    private EntityManager em;

    /**
     * DB 저장
     */
    public void save(Member member){
        em.persist(member);
    }

    /**
     * DB 객체 탐색
     */
    public Member findOneMember(String id){
        return em.find(Member.class, id);
    }

    public List<Member> findAllMember(){
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Member> findByNickname(@Param("nickname") String nickname) {
        return em.createQuery("select m from Member m where m.nickname = :nickname" , Member.class)
                .setParameter("nickname", nickname)
                .getResultList();
    }

    public List<Member> findById(@Param("Id")String id){
        return em.createQuery("select m from Member m where m.id = :id", Member.class)
                .setParameter("id", id)
                .getResultList();
    }

    /**
     * 중복 체크
     */
    public boolean existsByNickname(String nickname){
        List<Member> getMember = findByNickname(nickname);
        if(!getMember.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public boolean existsById(String id){
        List<Member> getMember = findById(id);
        if(!getMember.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
