package com.example.springlab2.service.Implementation;

import com.example.springlab2.service.Command;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Component;

@Component
public class DeleteBook implements Command<Void> {
    private final BookService bookService;
    Integer id;

    public DeleteBook(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public Void execute() {
        bookService.deleteBook(id);
        return null;
    }

    public void setBookId(Integer id){
        this.id = id;
    }

}
