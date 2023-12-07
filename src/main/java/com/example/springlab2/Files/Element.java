package com.example.springlab2.Files;

import com.example.springlab2.service.Visitor;

public interface Element {


    void add(Element a);

    Element get(int nr);
    void print();
    void remove(Element a);
    default void accept(Visitor visitor){};

}
