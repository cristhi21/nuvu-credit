package com.nuvucreditcvargas.nuvucredit.web.controller;

import com.nuvucreditcvargas.nuvucredit.persistence.crud.FranchiseCrudRepository;
import com.nuvucreditcvargas.nuvucredit.persistence.entity.Franchise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
