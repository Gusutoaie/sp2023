package com.example.springlab2.service.Implementation;

import com.example.springlab2.Files.Book;
import com.example.springlab2.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    BookRepository bookRepository;
    private final Map<Long, Book> books = new HashMap<>();
    private long nextId = 1;


    public Book createBook(Book bookData){
        long bookId = getNextId();
        books.put(bookId, bookData);
        return books.get(bookId);
    }


    public List<Book> getBooks() {
        return new ArrayList<>(books.values());
    }

    public Book getBookById(Integer bookId) {
        //return books.get(bookId);
        return bookRepository.getById(bookId);
    }

    public void updateBook(Long bookId, Book updatedBookData) {
        if (books.containsKey(bookId)) {
            books.put(bookId, updatedBookData);
        }
    }
    public void deleteBook(Long bookId) {
        books.remove(bookId);
    }
    private  long getNextId() {
        return nextId++;
    }
}
