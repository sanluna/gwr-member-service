package com.sanluna.members.controller;

import com.sanluna.members.model.PersonDTO;
import com.sanluna.members.model.entity.Person;
import com.sanluna.members.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "persons", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("")
    public PersonDTO save(@RequestBody PersonDTO dto) {
        return personService.save(dto.convertToEntity()).convertToDTO();
    }

    @GetMapping("")
    public List<PersonDTO> fetchAll() {
        return personService.fetchAll().stream().map(Person::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public PersonDTO getById(@PathVariable("id") String ID) {
        return personService.getById(ID).convertToDTO();
    }

    @DeleteMapping("")
    public void delete(@RequestBody PersonDTO dto) {
        personService.delete(dto.convertToEntity());
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") String ID) {
        personService.deleteById(ID);
    }

}
