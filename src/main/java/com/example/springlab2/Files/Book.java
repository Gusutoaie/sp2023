package com.example.springlab2.Files;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
public class Book extends Section implements Visitee{
    public String title;
    public List<Author> au = new ArrayList<Author>();
    public TableOfContents tb;

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
//    public int createChapter(String nume)
//    { Chapter a = new Chapter();
//        a.name=nume;
//        ch.add(a);
//        return ch.indexOf(a);
//    }
//    public Chapter getChapter(int nr)
//    {
//        return ch.get(nr);
//    }
}