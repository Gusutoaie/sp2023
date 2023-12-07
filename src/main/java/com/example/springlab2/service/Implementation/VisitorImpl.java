package com.example.springlab2.service.Implementation;

import com.example.springlab2.Files.*;
import com.example.springlab2.service.Visitor;

public class VisitorImpl implements Visitor {
    @Override
    public void visitParagraph(Pharagraph p) {

    }

    @Override
    public void visitSection(Section s) {
        System.out.println(s.getTitle());

    }

    @Override
    public void visitImage(Image image) {

    }

    @Override
    public void visitTable(Table table) {

    }

    @Override
    public void visitBook(Book book) {
        System.out.println("Book: " + book.title);
        System.out.println();
        System.out.println("Authors:");
        for (Author a : book.getAuthors()) {
            a.print();
        }

        System.out.println();
        for (Element et : book.el) {
            ((Visitee)et).accept(this);
        }
    }

    @Override
    public void visitTableOfContents(TableOfContents tableOfContents) {

    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {

    }
}
