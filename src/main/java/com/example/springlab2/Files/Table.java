package com.example.springlab2.Files;

import com.example.springlab2.service.Visitor;

public class Table implements Element,Visitee {
    public String title;

    public Table(String title) {
        this.title = title;
    }

    public Table() {
        this.title = "";
    }

    public void print() {
        System.out.println("Table with name : " + title);
    }

    @Override
    public void add(Element a) {

    }

    @Override
    public Element get(int nr) {
        return null;
    }

    @Override
    public void remove(Element a) {

    }

    @Override
    public void accept(Visitor v) {
        v.visitTable(this);
    }
}

