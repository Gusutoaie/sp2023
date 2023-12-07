package com.example.springlab2.controllers;

import com.example.springlab2.Files.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BooksController {
    private List<Book> books = new ArrayList<>();

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

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return books;
    }

    @GetMapping("books/{id}")
    public Book getBookById(@PathVariable Long id) {


        return

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        updatedBook.setId(id);
        return books.save(updatedBook);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable Long id) {
        books.deleteById(id);
    }

}