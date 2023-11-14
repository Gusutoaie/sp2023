package com.example.springlab2.Files;

public class RenderContentVisitor implements Visitor {
    @Override
    public void visitParagraph(Pharagraph p) {

    }

    @Override
    public void visitSection(Section s) {

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
}
