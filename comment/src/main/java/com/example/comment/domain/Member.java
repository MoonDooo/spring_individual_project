package com.example.comment.domain;

import com.example.comment.service.PasswordConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "member")
public class Member {
    @Id
    @Column(name = "member_id")
    private Long Id;

    @Convert(converter = PasswordConverter.class)
    private String passwd;

    private String name;
    private String nickName;

    @OneToMany(mappedBy = "member")
    private List<Comment> comments = new ArrayList<>();
}
