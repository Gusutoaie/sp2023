package com.example.springlab2.command;

import com.example.springlab2.service.Command;
import com.example.springlab2.service.Implementation.BookService;

public interface CommandExecutor {
    abstract Request executeCommand(Command command, BookService bookService);

}
