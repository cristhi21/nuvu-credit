package com.nuvucreditcvargas.nuvucredit.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class hello {

    @ResponseBody
    @GetMapping("/all")
    String home(){
        return "Hello world";
    }
}
