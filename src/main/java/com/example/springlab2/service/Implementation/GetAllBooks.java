package com.example.springlab2.service.Implementation;

import com.example.springlab2.Files.Book;
import com.example.springlab2.service.Command;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class GetAllBooks implements Command<List<Book>> {
    private final BookService bookService;

    public GetAllBooks(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public List<Book> execute() {
        return bookService.getBooks();
    }
}
