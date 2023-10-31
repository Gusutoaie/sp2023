package com.example.springlab2;

import com.example.springlab2.Files.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLab2Application {
    public static void main(String[] args) {
        Section cap1 = new Section("Capitolul 1");
        Pharagraph p1 = new Pharagraph("Paragraph 1");
        cap1.add(p1);
        Pharagraph p2 = new Pharagraph("Paragraph 2");
        cap1.add(p2);
        Pharagraph p3 = new Pharagraph("Paragraph 3");
        cap1.add(p3);
        Pharagraph p4 = new Pharagraph("Paragraph 4");
        cap1.add(p4);
        System.out.println("Printing without Alignment");
        System.out.println();
        cap1.print();
        p1.setAlignStrategy(new AlignCenter());
        p2.setAlignStrategy(new AlignRight());
        p3.setAlignStrategy(new AlignLeft());


        System.out.println();
        System.out.println();
        System.out.println("Printing with Alignment");
        System.out.println();
        cap1.print();
    }

}
