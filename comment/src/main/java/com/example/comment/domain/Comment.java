package com.example.comment.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class Comment {
    public Comment(String comment, Member member){
        this.comment = comment;
        this.member = member;
    }

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long Id;

    @Lob
    private String comment;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;



}
