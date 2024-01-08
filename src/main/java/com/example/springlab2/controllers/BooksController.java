package com.example.springlab2.controllers;

import com.example.springlab2.Files.*;
import com.example.springlab2.command.AsynchronousExecutor;
import com.example.springlab2.command.CommandExecutor;
import com.example.springlab2.command.Request;
import com.example.springlab2.service.Implementation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.TimeUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@RestController
public class BooksController {
    private List<Book> books = new ArrayList<>();
    List<Request<?>> requests;
    CommandExecutor syncCommandExecutor;
    CommandExecutor asyncCommandExecutor;
    ExecutorService executorService;
    private final GetAllBooks getAllBooksCommand;
    private final AddBook addBookCommand;
    private final DeleteBook deleteBookCommand;

    private final GetBookById getBookById;
    private final UpdateBook updateBook;
    private final BookService bookService;

    @Autowired
    public BooksController(GetAllBooks getAllBooksCommand, AddBook addBookCommand, DeleteBook deleteBookCommand, GetBookById getBookById, UpdateBook updateBook,BookService bookService) {
        this.getAllBooksCommand = getAllBooksCommand;
        this.addBookCommand = addBookCommand;
        this.deleteBookCommand = deleteBookCommand;
        this.getBookById = getBookById;
        this.updateBook = updateBook;
        this.requests = new ArrayList<>();
        this.bookService = bookService;

        this.asyncCommandExecutor = new AsynchronousExecutor();

        this.executorService = Executors.newFixedThreadPool(2);

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        // Schedule the function to run every 10 seconds
        scheduler.scheduleAtFixedRate(this::processRequests, 0, 10, TimeUnit.SECONDS);
    }

    public void processRequests() {
        System.out.println("Processing requests");

        for (Request request : requests) {
            if (!request.isCompleted()) {
                executorService.submit(() -> {
                    System.out.println("Executing request " + request.getId());

                    request.setResult(request.getCommand().execute());
                    request.setCompleted(true);

                    System.out.println("Request " + request.getId() + " completed");
                });
            }
        }
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
    public ResponseEntity<Integer> createBook(@RequestBody Book book) {
        addBookCommand.setBook(book);
        Request request = asyncCommandExecutor.executeCommand(addBookCommand, bookService);
        request.setId(requests.size());

        requests.add(request);
        return new ResponseEntity<>(requests.size() - 1, HttpStatus.OK);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book updatedBook) {
        updateBook.setBook(id, updatedBook);
        return updateBook.execute();
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable Integer id) {
        deleteBookCommand.setBookId(id);
        deleteBookCommand.execute();
    }

}