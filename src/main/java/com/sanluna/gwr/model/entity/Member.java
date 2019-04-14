package com.sanluna.gwr.model.entity;

import com.sanluna.gwr.model.MemberDTO;
import com.sanluna.commons.model.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.sanluna.commons.util.Converter.toDTO;

@Entity
@Table(name = "members")
public class Member extends BaseEntity<Member> {

    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "password")
    private String password;

    public String getUsername() {
        return username;
    }

    public Member setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Member setPassword(String password) {
        this.password = password;
        return this;
    }

    public MemberDTO convertToDTO() {
        return toDTO(this, new MemberDTO())
                .setPassword(this.password)
                .setUsername(this.username);
    }
}
