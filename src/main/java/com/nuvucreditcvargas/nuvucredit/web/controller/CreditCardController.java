package com.nuvucreditcvargas.nuvucredit.web.controller;

import com.nuvucreditcvargas.nuvucredit.persistence.crud.CreditCardCrudRepository;
import com.nuvucreditcvargas.nuvucredit.persistence.entity.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/credit_card")
public class CreditCardController {

    @Autowired
    private CreditCardCrudRepository creditCardCrudRepository;

    @GetMapping
    public ResponseEntity<List<CreditCard>> getCreditCard(){
        List<CreditCard> persons = (List<CreditCard>) creditCardCrudRepository.findAll();
        return ResponseEntity.ok(persons);
    }
}
