package com.example.springlab2.Files;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Section implements Element,Visitee {
    public String title;

    public List<Element> el = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }



    @Override
    public void add(Element a) {
        el.add(a);
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
        v.visitSection(this);
    }
}
