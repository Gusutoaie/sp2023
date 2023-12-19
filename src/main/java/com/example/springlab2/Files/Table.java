package com.example.springlab2.Files;

import com.example.springlab2.service.Visitor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "BookTable")
public class Table extends BaseElement implements Visitee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
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

