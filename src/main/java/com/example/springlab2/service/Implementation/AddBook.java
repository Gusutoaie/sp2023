package com.example.springlab2.service.Implementation;

import com.example.springlab2.Files.Book;
import com.example.springlab2.service.Command;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AddBook implements Command<CompletableFuture<Book>> {
    private final BookService bookService;
    Book book1;

    public AddBook(BookService bookService) {
        this.bookService = bookService;
    }


    @Override
    @Async
    public CompletableFuture<Book> execute() {
        return bookService.createBook(book1);
    }
    public void setBook(Book book){
        book1 = book;
    }

}
