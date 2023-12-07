package com.example.springlab2.Files;

import com.example.springlab2.service.Visitor;
import lombok.Data;
import lombok.Getter;
@Data
public class Pharagraph implements  Element,Visitee{
    @Getter
    public String text;
    private AlignStrategy alignStrategy;

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

    @Override
    public void accept(Visitor visitor) {
        visitor.visitParagraph(this);
    }







}
