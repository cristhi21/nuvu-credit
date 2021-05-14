package com.nuvucreditcvargas.nuvucredit.web.controller;

import com.nuvucreditcvargas.nuvucredit.persistence.crud.PersonCrudRepository;
import com.nuvucreditcvargas.nuvucredit.persistence.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonCrudRepository personCrudRepository;

    @GetMapping
    public ResponseEntity<List<Person>> getAll(){
        List<Person> persons = (List<Person>) personCrudRepository.findAll();
        return ResponseEntity.ok(persons);
    }

    @RequestMapping(value="{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id){
        Optional<Person> optionalPerson = personCrudRepository.findById(id);
        //return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        return optionalPerson.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }
}
