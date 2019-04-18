package com.sanluna.members.repository;

import com.sanluna.commons.repository.AOWR_Repository;
import com.sanluna.members.model.entity.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends AOWR_Repository<Member> {

    Member findByUsername(String username);

}
