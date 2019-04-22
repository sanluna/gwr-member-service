package com.sanluna.members.model.entity;

import com.sanluna.commons.model.entity.BaseEntity;
import com.sanluna.commons.util.Converter;
import com.sanluna.members.model.PersonDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
public class Person extends BaseEntity<Person> {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "social_number")
    private String socialNr;
    @Column(name = "is_male")
    private boolean male;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getSocialNr() {
        return socialNr;
    }

    public Person setSocialNr(String socialNr) {
        this.socialNr = socialNr;
        return this;
    }

    public boolean isMale() {
        return male;
    }

    public Person setMale(boolean male) {
        this.male = male;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Person setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public PersonDTO convertToDTO() {
        return Converter.toDTO(this, new PersonDTO())
                .setEmail(this.email)
                .setFirstName(this.firstName)
                .setLastName(this.lastName)
                .setMale(this.male)
                .setPhoneNumber(this.phoneNumber)
                .setSocialNr(this.socialNr);
    }
}
