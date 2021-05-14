package com.nuvucreditcvargas.nuvucredit.web.controller;

import com.nuvucreditcvargas.nuvucredit.persistence.crud.PersonCrudRepository;
import com.nuvucreditcvargas.nuvucredit.persistence.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return optionalPerson.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person){
        return new ResponseEntity<>(personCrudRepository.save(person), HttpStatus.CREATED) ;
    }

    @PutMapping(value="{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") final Long id, @RequestBody Person person){
        Optional<Person> optionalPerson = personCrudRepository.findById(id);
        System.out.println(optionalPerson);
        if(optionalPerson.isPresent()) {
            Person updatePerson = optionalPerson.get();
            updatePerson.setNamePerson(person.getNamePerson());
            updatePerson.setLastName(person.getLastName());
            updatePerson.setCellphone(person.getCellphone());
            updatePerson.setAdress(person.getAdress());
            updatePerson.setMail(person.getMail());
            personCrudRepository.save(updatePerson);
            return ResponseEntity.ok(updatePerson);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable("id") Long id){
        personCrudRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
