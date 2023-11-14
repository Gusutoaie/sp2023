package com.example.springlab2.Files;

import java.util.ArrayList;
import java.util.List;

public class TableOfContentUpdate implements Visitor {
    private List<String> tocEntries;

    public TableOfContentUpdate() {
        this.tocEntries = new ArrayList<>();
    }

    public List<String> getToC() {
        return tocEntries;
    }
    @Override
    public void visitParagraph(Pharagraph p) {

    }

    @Override
    public void visitSection(Section s) {
        tocEntries.add(s.getTitle());
        for (Element element : s.getContent()) {
            element.accept(this); // Continue visiting sub-elements
        }
    }

    @Override
    public void visitImage(Image image) {

    }

    @Override
    public void visitTable(Table table) {

    }

    @Override
    public void visitBook(Book book) {

    }
}
