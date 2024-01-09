package com.example.springlab2.command;

import com.example.springlab2.Files.Book;

public interface Observer {
    void update(Book book);
}
