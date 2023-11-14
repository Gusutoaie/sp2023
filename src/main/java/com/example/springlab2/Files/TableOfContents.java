package com.example.springlab2.Files;

import java.awt.*;

public class TableOfContents implements Element{
    @Override
    public void print() {
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
    public static void createTableOfContent() {
        Book b = new Book("The book");
        Section cap1 = new Section("Chapter 1");
        Section cap11 = new Section("Subchapter 1.1");
        Section cap2 = new Section("Chapter 2");
        cap1.add(new Pharagraph("Paragraph 1"));
        cap1.add(new Pharagraph("Paragraph 2"));
        cap1.add(new Pharagraph("Paragraph 3"));

        cap11.add(new ImageProxy("ImageOne"));
        cap11.add(new Image("ImageTwo"));

        cap2.add(new Pharagraph("Paragraph 4"));

        cap1.add(cap11);
        cap1.add(new Pharagraph("Some text"));
        cap1.add(new Table("Table 1"));
        b.addContent(cap1);
        b.addContent(cap2);
        TableOfContentUpdate tocUpdate = new TableOfContentUpdate();
        b.accept(tocUpdate);
        tocUpdate.getToC().accept(new RenderContentVisitor());
    }
}