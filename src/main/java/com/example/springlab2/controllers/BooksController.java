package com.example.springlab2.controllers;

import com.example.springlab2.Files.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {
    @GetMapping("/statistics")
    public ResponseEntity<?> printStatistics() {
        Section cap1 = new Section("Capitolul 1");
        Pharagraph p1 = new Pharagraph("Paragraph 1");
        cap1.add(p1);
        Pharagraph p2 = new Pharagraph("Paragraph 2");
        cap1.add(p2);
        Pharagraph p3 = new Pharagraph("Paragraph 3");
        cap1.add(p3);
        Pharagraph p4 = new Pharagraph("Paragraph 4");
        cap1.add(p4);
        cap1.add(new ImageProxy("ImageOne"));
        cap1.add(new Image("ImageTwo"));
        cap1.add(new Pharagraph("Some text"));
        cap1.add(new Table("Table 1"));
        BookStatistics stats = new BookStatistics();
        cap1.accept(stats);
        stats.printStatistics();
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}