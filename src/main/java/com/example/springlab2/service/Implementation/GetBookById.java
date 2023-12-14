package com.example.springlab2.service.Implementation;

import com.example.springlab2.Files.Book;
import com.example.springlab2.service.Command;
import org.springframework.stereotype.Component;

@Component
public class GetBookById implements Command<Book> {
    private final BookService bookService;

    public GetBookById(BookService bookService) {
        this.bookService = bookService;
    }
    Integer id;
    @Override
    public Book execute() {
        return bookService.getBookById(id);
    }

    public void setId(Integer id){
        this.id=id;
    }
}
