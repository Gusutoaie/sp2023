package com.example.springlab2.Files;

public class Pharagraph implements  Element {
    public String text;

    public Pharagraph(){}
    public Pharagraph(String text) {
        this.text = text;
    }

    public void print() {
        System.out.println("Paragraph: " + text);
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
}
