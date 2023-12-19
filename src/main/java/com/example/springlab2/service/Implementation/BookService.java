package com.example.springlab2.service.Implementation;

import com.example.springlab2.Files.Book;
import com.example.springlab2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;

@Service
@EnableAsync(proxyTargetClass = true)
public class BookService {
    BookRepository bookRepository;
    //private final Map<Long, Book> books = new HashMap<>();
    private long nextId = 1;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Async
    public CompletableFuture<Book> createBook(Book bookData) {
        Book createdBook = bookRepository.save(bookData);
        return CompletableFuture.completedFuture(createdBook);
    }


    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Integer bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        return optionalBook.orElse(null);
    }


    public void updateBook(Integer bookId, Book updatedBookData) {
        if (bookRepository.existsById(bookId)) {
            updatedBookData.setId(bookId);
            bookRepository.save(updatedBookData);
        }
    }
    public void deleteBook(Integer bookId) {
        bookRepository.deleteById(bookId);
    }
    private  long getNextId() {
        return nextId++;
    }
}
