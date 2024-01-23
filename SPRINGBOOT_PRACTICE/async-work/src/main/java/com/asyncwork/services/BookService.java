package com.asyncwork.services;

import com.asyncwork.models.Book;

import java.util.List;

public interface BookService {

    Book create(Book book);
    Book update(Book book);
    void delete(int id);
    Book fetchById(int id);
    List<Book> fetchAll();
}
