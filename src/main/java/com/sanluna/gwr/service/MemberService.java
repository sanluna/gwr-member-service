package com.sanluna.gwr.service;

import com.sanluna.gwr.model.entity.Member;
import com.sanluna.gwr.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sanluna.commons.service.BaseService;
import com.sanluna.commons.service.GenericService;

@Service
public class MemberService extends GenericService<Member> implements BaseService<Member> {

    @Autowired
    private MemberRepository repository;

    public Member findByUsername(String username){
        return checkIfFound(repository.findByUsername(username), "Member with username: " + username + " not found!");
    }

}
