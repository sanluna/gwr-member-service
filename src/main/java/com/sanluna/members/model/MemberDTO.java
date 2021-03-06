package com.sanluna.members.model;

import com.sanluna.commons.model.BaseDTO;
import com.sanluna.members.model.entity.Member;
import com.sanluna.members.model.entity.Person;

import static com.sanluna.commons.util.Converter.toEntity;

public class MemberDTO extends BaseDTO<MemberDTO> {

    private String username;
    private String password;
    private String roles;
    private String tenant;
    private Person person;

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

    public String getRoles() {
        return roles;
    }

    public MemberDTO setRoles(String roles) {
        this.roles = roles;
        return this;
    }

    public String getTenant() {
        return tenant;
    }

    public MemberDTO setTenant(String tenant) {
        this.tenant = tenant;
        return this;
    }

    public Member convertToEntity() {
        return toEntity(this, new Member())
                .setPassword(this.password)
                .setUsername(this.username)
                .setRoles(this.roles)
                .setTenant(this.tenant);
    }
}
