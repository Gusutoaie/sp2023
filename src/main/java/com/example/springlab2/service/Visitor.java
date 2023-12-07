package com.example.springlab2.service;

import com.example.springlab2.Files.*;

public interface Visitor {
    void visitParagraph(Pharagraph p);
    void visitSection(Section s);
    void visitImage(Image image);
    void visitTable(Table table);
    void visitBook(Book book);
    void visitPharagraph(Pharagraph pharagraph);
    void visitTableOfContent(TableOfContents tableOfContents);
    void visitImageProxy(ImageProxy imageProxy);


}
