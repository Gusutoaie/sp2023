package com.example.springlab2.Files;

import com.example.springlab2.service.Visitor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public interface Element {

    void add(Element a);

    Element get(int nr);
    void print();
    void remove(Element a);
    default void accept(Visitor visitor){};

}
