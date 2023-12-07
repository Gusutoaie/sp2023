package com.example.springlab2.Files;

public interface Element {


    void add(Element a);

    Element get(int nr);

    void remove(Element a);

    void accept(TableOfContentUpdate tableOfContentUpdate);
}
