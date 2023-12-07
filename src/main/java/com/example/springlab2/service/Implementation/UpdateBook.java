package com.example.springlab2.service.Implementation;

import com.example.springlab2.Files.Book;
import com.example.springlab2.service.Command;
import org.springframework.stereotype.Component;

@Component
public class UpdateBook implements Command<Book> {
    private final BookService bookService;
    Long id;
    Book book;

    public UpdateBook(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public Book execute() {
        bookService.updateBook(id,book);
        return this.book;
    }
    public void setBook(Long id, Book newBook){
        this.id = id;
        this.book = newBook;
    }

}
