package com.sanluna.members.model.entity;

import com.sanluna.commons.model.entity.BaseEntity;
import com.sanluna.members.model.MemberDTO;

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
    @Column(name = "roles")
    private String roles;
    @Column(name = "tenant")
    private String tenant;

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

    public String getRoles() {
        return roles;
    }

    public Member setRoles(String roles) {
        this.roles = roles;
        return this;
    }

    public String getTenant() {
        return tenant;
    }

    public Member setTenant(String tenant) {
        this.tenant = tenant;
        return this;
    }

    public MemberDTO convertToDTO() {
        return toDTO(this, new MemberDTO())
                .setPassword(this.password)
                .setUsername(this.username)
                .setRoles(this.roles)
                .setTenant(this.tenant);
    }

    @Override
    public Member updateEntity(Member newEntity) {
        if(newEntity.getUsername() != null) setUsername(newEntity.getUsername());
        if(newEntity.getRoles() != null) setRoles(newEntity.getRoles());
        if(newEntity.getTenant() != null) setTenant(newEntity.getTenant());
        return this;
    }
}
