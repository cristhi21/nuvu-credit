package com.nuvucreditcvargas.nuvucredit.web.controller;

import com.nuvucreditcvargas.nuvucredit.domain.service.PersonService;
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
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> getAll(){
        List<Person> persons = (List<Person>) personService.getAll();
        return ResponseEntity.ok(persons);
    }

    @GetMapping(value="{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id){
        Optional<Person> optionalPerson = personService.findById(id);
        return optionalPerson.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person){
        return new ResponseEntity<>(personService.save(person), HttpStatus.CREATED) ;
    }

    @PutMapping(value="{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") final Long id, @RequestBody Person person){
        Optional<Person> optionalPerson = personService.findById(id);
        if(optionalPerson.isPresent()) {
            return ResponseEntity.ok(personService.update(optionalPerson, person));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable("id") Long id){
        personService.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
