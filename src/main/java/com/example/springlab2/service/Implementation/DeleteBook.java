package com.example.springlab2.service.Implementation;

import com.example.springlab2.service.Command;
import org.springframework.stereotype.Component;

@Component
public class DeleteBook implements Command<Void> {
    private final BookService bookService;
    Long id;

    public DeleteBook(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public Void execute() {
        bookService.deleteBook(id);
        return null;
    }

    public void setBookId(Long id){
        this.id = id;
    }

}
