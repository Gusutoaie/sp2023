package com.example.springlab2.Files;

public class AlignLeft implements AlignStrategy{
    @Override
    public String render(Pharagraph context) {
        return context.getText();
    }
}
