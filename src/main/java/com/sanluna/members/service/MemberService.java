package com.sanluna.members.service;

import com.sanluna.commons.exceptions.AlreadyExistsException;
import com.sanluna.commons.exceptions.NotFoundException;
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

    @Override
    public Member save(Member entity) {
        try {
            findByUsername(entity.getUsername());
        } catch (NotFoundException e){
            return super.save(entity);
        }
        throw new AlreadyExistsException("Member with username " + entity.getUsername() + " already exists!");
    }

    public Member findByUsername(String username) {
        return checkIfFound(repository.findByUsername(username), "Member with username: " + username + " not found!");
    }

}
