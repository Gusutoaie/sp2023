package com.example.springlab2.controllers;

import com.example.springlab2.Files.*;
import com.example.springlab2.service.Implementation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BooksController {
    private List<Book> books = new ArrayList<>();

    private final GetAllBooks getAllBooksCommand;
    private final AddBook addBookCommand;
    private final DeleteBook deleteBookCommand;

    private final GetBookById getBookById;
    private final UpdateBook updateBook;
    @Autowired
    public BooksController(GetAllBooks getAllBooksCommand, AddBook addBookCommand, DeleteBook deleteBookCommand, GetBookById getBookById, UpdateBook updateBook) {
        this.getAllBooksCommand = getAllBooksCommand;
        this.addBookCommand = addBookCommand;
        this.deleteBookCommand = deleteBookCommand;
        this.getBookById = getBookById;
        this.updateBook = updateBook;
    }


    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return getAllBooksCommand.execute();
    }

    @GetMapping("books/{id}")
    public Book getBookById(@PathVariable Integer id) {
        getBookById.setId(id);
        return getBookById.execute();
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        addBookCommand.setBook(book);
        return addBookCommand.execute();
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        updateBook.setBook(id, updatedBook);
        return updateBook.execute();
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable Long id) {
        deleteBookCommand.setBookId(id);
        deleteBookCommand.execute();
    }

}