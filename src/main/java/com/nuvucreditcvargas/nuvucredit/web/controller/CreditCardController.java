package com.nuvucreditcvargas.nuvucredit.web.controller;

import com.nuvucreditcvargas.nuvucredit.persistence.crud.CreditCardCrudRepository;
import com.nuvucreditcvargas.nuvucredit.persistence.entity.CreditCard;
import com.nuvucreditcvargas.nuvucredit.persistence.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/credit_card")
public class CreditCardController {

    @Autowired
    private CreditCardCrudRepository creditCardCrudRepository;

    @GetMapping
    public ResponseEntity<List<CreditCard>> getAllCreditCard(){
        List<CreditCard> persons = (List<CreditCard>) creditCardCrudRepository.findAll();
        return ResponseEntity.ok(persons);
    }

    @GetMapping(value="{id}")
    public ResponseEntity<CreditCard> getCreditCard(@PathVariable("id") Long id){
        Optional<CreditCard> optionalCreditCard = creditCardCrudRepository.findById(id);
        return optionalCreditCard.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<CreditCard> save(@RequestBody CreditCard creditCard){
        return new ResponseEntity<>(creditCardCrudRepository.save(creditCard), HttpStatus.CREATED) ;
    }

    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> deleteCreditCard(@PathVariable("id") Long id){
        creditCardCrudRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
