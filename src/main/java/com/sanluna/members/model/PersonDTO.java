package com.sanluna.members.model;

import com.sanluna.commons.model.BaseDTO;
import com.sanluna.members.model.entity.Person;

import static com.sanluna.commons.util.Converter.toEntity;

;

public class PersonDTO extends BaseDTO<PersonDTO> {

    private String firstName;
    private String lastName;
    private String socialNr;
    private boolean male;
    private String email;
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public PersonDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PersonDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getSocialNr() {
        return socialNr;
    }

    public PersonDTO setSocialNr(String socialNr) {
        this.socialNr = socialNr;
        return this;
    }

    public boolean isMale() {
        return male;
    }

    public PersonDTO setMale(boolean male) {
        this.male = male;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PersonDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PersonDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Person convertToEntity() {
        return toEntity(this, new Person())
                .setEmail(this.email)
                .setFirstName(this.firstName)
                .setLastName(this.lastName)
                .setMale(this.male)
                .setPhoneNumber(this.phoneNumber)
                .setSocialNr(this.socialNr);
    }
}
