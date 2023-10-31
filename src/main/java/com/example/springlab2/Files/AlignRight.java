package com.example.springlab2.Files;

public class AlignRight implements AlignStrategy{
    @Override
    public String render(Pharagraph context) {
        int totalWidth = 58; // Total width of the aligned text (adjust as needed)
        String text = context.getText();
        int textWidth = text.length();

        if (textWidth >= totalWidth) {

            return text; // Text is longer than the total width, can't right-align.

        }

        int padding = totalWidth - textWidth;
        String alignedText = " ".repeat(padding) + text;

        return alignedText;
    }
}
