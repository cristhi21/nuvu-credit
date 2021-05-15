package com.nuvucreditcvargas.nuvucredit.web.controller;

import com.nuvucreditcvargas.nuvucredit.persistence.crud.FranchiseCrudRepository;
import com.nuvucreditcvargas.nuvucredit.persistence.entity.CreditCard;
import com.nuvucreditcvargas.nuvucredit.persistence.entity.Franchise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/franchise")
public class FranchiseController {

    @Autowired
    private FranchiseCrudRepository franchiseCrudRepository;

    @GetMapping
    public ResponseEntity<List<Franchise>> getAll(){
        List<Franchise> persons = (List<Franchise>) franchiseCrudRepository.findAll();
        return ResponseEntity.ok(persons);
    }

    @GetMapping(value="{id}")
    public ResponseEntity<Franchise> getFranchise(@PathVariable("id") Integer id){
        Optional<Franchise> optionalCreditCard = franchiseCrudRepository.findById(id);
        return optionalCreditCard.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<Franchise> save(@RequestBody Franchise franchise){
        return new ResponseEntity<>(franchiseCrudRepository.save(franchise), HttpStatus.CREATED) ;
    }

    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> deleteCreditCard(@PathVariable("id") Integer id){
        franchiseCrudRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
