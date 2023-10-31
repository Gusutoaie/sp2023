package com.example.springlab2.Files;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SubChapter {
    String text;
    Collection<Image> Images= new ArrayList<Image>();
    Collection<Table> Tables= new ArrayList<Table>();
    Collection<Pharagraph> Paragraphs= new ArrayList<Pharagraph>();

    @Override
    public String toString() {
        return "SubChapter{" +
                "text='" + text + '\'' +
                ", Images=" + Images +
                ", Tables=" + Tables +
                ", Paragraphs=" + Paragraphs +
                '}';
    }

    public SubChapter(String text) {
        this.text = text;
    }

    public void createNewParagraph(String s) {
        Paragraphs.add(new Pharagraph(s));
    }

    public void createNewImage(String s) {
        Images.add(new Image(s));
    }

    public void createNewTable(String s) {
        Tables.add(new Table(s));
    }

    public void print() {
        System.out.println(this);
    }
}
