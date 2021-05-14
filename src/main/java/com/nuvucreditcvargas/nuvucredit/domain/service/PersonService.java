package com.nuvucreditcvargas.nuvucredit.domain.service;

import com.nuvucreditcvargas.nuvucredit.persistence.crud.PersonCrudRepository;
import com.nuvucreditcvargas.nuvucredit.persistence.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonCrudRepository personCrudRepository;

    public List<Person> getAll() {
        return (List<Person>) personCrudRepository.findAll();
    }

    public Optional<Person> findById(Long personId) {
        return personCrudRepository.findById(personId);
    }

    public Person save(Person person) {
        return personCrudRepository.save(person);
    }

    public Person update(Optional<Person> optionalPerson, Person person) {
            Person updatePerson = optionalPerson.get();
            updatePerson.setNamePerson(person.getNamePerson());
            updatePerson.setLastName(person.getLastName());
            updatePerson.setCellphone(person.getCellphone());
            updatePerson.setAdress(person.getAdress());
            updatePerson.setMail(person.getMail());
            return personCrudRepository.save(updatePerson);
    }

    public void deleteById(Long personId){
        personCrudRepository.deleteById(personId);
    }
}
