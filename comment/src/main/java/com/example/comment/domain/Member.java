package com.example.comment.domain;

import com.example.comment.service.PasswordConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "member")
public class Member {

    public Member(String id, String passwd, String name, String nickname){
        this.id = id;
        this.passwd = passwd;
        this.name = name;
        this.nickname = nickname;
    }

    @Id
    @Column(name = "member_id")
    private String id;

    @Convert(converter = PasswordConverter.class)
    private String passwd;

    private String name;
    private String nickname;

    @OneToMany(mappedBy = "member")
    private List<Comment> comments = new ArrayList<>();


}
