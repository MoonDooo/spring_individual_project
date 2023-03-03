package com.example.comment.dto.memberDto;

import lombok.Data;

@Data
public class CreateMemberRequestDTO {
    private String id;
    private String passwd;
    private String name;
    private String nickName;

    public CreateMemberRequestDTO(String id, String passwd, String name, String nickName) {
        this.id = id;
        this.passwd = passwd;
        this.name = name;
        this.nickName = nickName;
    }
}
