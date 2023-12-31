package com.example.springlab2.Files;

import com.example.springlab2.service.Visitor;

public class BookStatistics implements Visitor {
    private int images=0;
    private int paragraphs=0;
    private int tables=0;
    @Override
    public void visitParagraph(Pharagraph p) {
        paragraphs +=1;

    }

    @Override
    public void visitSection(Section s) {

    }

    @Override
    public void visitImage(Image image) {
        images += 1;

    }

    @Override
    public void visitTable(Table table) {
        tables += 1 ;

    }

    @Override
    public void visitBook(Book book) {

    }



    @Override
    public void visitTableOfContent(TableOfContent tableOfContents) {

    }

    @Override
    public void visitImageProxy(ImageProxy imageProxy) {

    }
    public void printStatistics()
    {
        System.out.println("Book Statistics:");
        System.out.println("*** Number of images: " + images);
        System.out.println("*** Number of tables: "+ tables);
        System.out.println("*** Number of paragraphs: " + paragraphs);
    }
}
