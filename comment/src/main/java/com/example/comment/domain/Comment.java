package com.example.comment.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class Comment {
    public Comment(String comment, Member member){
        this.comment = comment;
        this.member = member;
        this.localDateTime = LocalDateTime.now();
    }

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long Id;

    @Lob
    private String comment;

    private LocalDateTime localDateTime;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
