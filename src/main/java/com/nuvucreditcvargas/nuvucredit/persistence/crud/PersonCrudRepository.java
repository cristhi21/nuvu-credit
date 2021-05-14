package com.nuvucreditcvargas.nuvucredit.persistence.crud;

import com.nuvucreditcvargas.nuvucredit.persistence.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonCrudRepository extends CrudRepository<Person, Long> {

}
