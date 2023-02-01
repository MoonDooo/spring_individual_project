package com.example.comment.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Comment {
    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long Id;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
