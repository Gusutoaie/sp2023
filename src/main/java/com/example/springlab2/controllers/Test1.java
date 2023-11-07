package com.example.springlab2.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Test1 implements Inte {
    @Override
    public void f() {
        System.out.println("Test1");

    }
}
