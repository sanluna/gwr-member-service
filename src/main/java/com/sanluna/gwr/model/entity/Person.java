package com.sanluna.gwr.model.entity;

import com.sanluna.commons.model.BaseDTO;
import com.sanluna.commons.model.entity.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Person extends BaseEntity<Person> {
    public <T1 extends BaseDTO<T1>> T1 convertToDTO() {
        return null;
    }
}
