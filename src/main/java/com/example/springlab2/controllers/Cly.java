package com.example.springlab2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Cly {
    @Autowired
    public Cly(@Qualifier("test1") Inte inte){

    }

}
