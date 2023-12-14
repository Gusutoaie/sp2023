package com.example.springlab2.Files;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column
    public String name;

    public Author(String name) {
        this.name = name;
    }

    public Author() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("Author: " + name);
    }
}

