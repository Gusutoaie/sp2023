package com.example.springlab2.command;

import com.example.springlab2.service.Command;
import com.example.springlab2.service.Implementation.BookService;

public class AsynchronousExecutor implements CommandExecutor{
    @Override
    public Request executeCommand(Command command, BookService bookService) {
        return new Request<>(0, command, false, null);
    }
}
