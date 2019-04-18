package com.sanluna.members.service;

import com.sanluna.commons.service.BaseService;
import com.sanluna.commons.service.GenericService;
import com.sanluna.members.model.entity.Member;
import com.sanluna.members.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService extends GenericService<Member> implements BaseService<Member> {

    @Autowired
    private MemberRepository repository;

    public Member findByUsername(String username) {
        return checkIfFound(repository.findByUsername(username), "Member with username: " + username + " not found!");
    }

}
