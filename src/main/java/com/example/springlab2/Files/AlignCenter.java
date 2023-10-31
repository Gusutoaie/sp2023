package com.example.springlab2.Files;

public class AlignCenter implements AlignStrategy{
    @Override
    public String render(Pharagraph context) {
        int totalWidth = 80; // Total width of the aligned text (adjust as needed)
        String text = context.getText();
        int textWidth = text.length();

        if (textWidth >= totalWidth) {
            return text; // Text is longer than the total width, can't center-align.
        }

        int padding = (totalWidth - textWidth) / 2;
        String alignedText = " ".repeat(padding) + text;
        return alignedText;
    }
}
