package com.example.springlab2.service.Implementation;

import com.example.springlab2.Files.Book;
import com.example.springlab2.service.Command;
import org.springframework.stereotype.Component;

@Component
public class AddBook implements Command<Book> {
    private final BookService bookService;
    Book book1;

    public AddBook(BookService bookService) {
        this.bookService = bookService;
    }


    @Override
    public Book execute() {
        return bookService.createBook(book1);
    }
    public void setBook(Book book){
        book1 = book;
    }

}
