package com.sanluna.members.repository;

import com.sanluna.commons.repository.AOWR_Repository;
import com.sanluna.members.model.entity.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends AOWR_Repository<Person> {
}
