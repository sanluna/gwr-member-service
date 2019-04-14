package com.sanluna.gwr.model;

import com.sanluna.gwr.model.entity.Member;
import com.sanluna.commons.model.BaseDTO;

import static com.sanluna.commons.util.Converter.toEntity;

public class MemberDTO extends BaseDTO<MemberDTO> {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public MemberDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public MemberDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public Member convertToEntity() {
        return toEntity(this, new Member())
                .setPassword(this.password)
                .setUsername(this.username);
    }
}
