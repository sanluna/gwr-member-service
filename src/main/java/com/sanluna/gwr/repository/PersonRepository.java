package com.sanluna.gwr.repository;

import com.sanluna.gwr.model.entity.Person;
import org.springframework.stereotype.Repository;
import com.sanluna.commons.repository.AOWR_Repository;

@Repository
public interface PersonRepository extends AOWR_Repository<Person> {
}
