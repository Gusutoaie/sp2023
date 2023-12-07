package com.example.springlab2.service.Implementation;

import com.example.springlab2.Files.*;
import com.example.springlab2.service.Visitor;

import java.util.List;

public class VisitorImpl implements Visitor {
    List<Book> el;
    @Override
    public void visitBook(Book book) {
        System.out.println("Book: " + book.getTitle());
        System.out.println();
        System.out.println("Authors:");
        for (Author a : book.getAuthors()) {
            a.print();
        }

        System.out.println();
        for (Element et : book.getSections()) {
            ((Visitee)et).accept(this);
        }
    }


    @Override
    public void visitSection(Section section) {
        System.out.println(section.getTitle());
        for(Element e: section.getEl())
            e.accept(this);
    }

    @Override
    public void visitParagraph(Pharagraph paragraph) {
        if(paragraph.getAlignStrategy() == null)
            System.out.println("Paragraph: " + paragraph.getText());
        else
            paragraph.getAlignStrategy().render(paragraph.getText());
    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {
        imageProxy.loadRealImage().accept(this);
    }

    @Override
    public void visitImage(Image image) {


    }

    @Override
    public void visitTable(Table table) {

    }

    @Override
    public void visitTableOfContent(TableOfContent tableOfContent) {
        for (String s : tableOfContent.getEntries()){
            System.out.println(s);
        }

    }
}
