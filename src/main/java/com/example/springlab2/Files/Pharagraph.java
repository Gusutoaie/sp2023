package com.example.springlab2.Files;

import lombok.Getter;

public class Pharagraph implements  Element {
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
    public String render() {
        if (alignStrategy != null) {
            return alignStrategy.render(this);
        }
        return text;
    }


    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
        // Update the text with the new alignment strategy
        if (alignStrategy != null) {
            text = alignStrategy.render(this);
        }
    }

}
