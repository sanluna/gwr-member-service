package com.sanluna.gwr.repository;

import com.sanluna.gwr.model.entity.Member;
import org.springframework.stereotype.Repository;
import com.sanluna.commons.repository.AOWR_Repository;

@Repository
public interface MemberRepository extends AOWR_Repository<Member> {

    Member findByUsername(String username);

}
