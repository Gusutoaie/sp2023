package com.example.springlab2.Files;

import lombok.Data;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
@Data
public class Book extends Section implements Visitee {
    public String title;
    public List<Author> au = new ArrayList<Author>();
    public TableOfContents tb;
    public int id;

    public Book(String title) {
        super(title);
        this.title = title;
    }



    public void addAuthor(Author nume) {
        au.add(nume);
    }

    public void addContent(Element a) {
        el.add(a);
    }

    public List<Author> getAuthors() {
        return au;
    }
}