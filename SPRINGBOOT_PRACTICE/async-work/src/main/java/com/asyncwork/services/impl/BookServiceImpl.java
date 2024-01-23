package com.asyncwork.services.impl;

import com.asyncwork.models.Book;
import com.asyncwork.repositories.BookRepository;
import com.asyncwork.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book fetchById(int id) {
        return bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book, not found !!"));
    }

    @Override
    public List<Book> fetchAll() {
        return bookRepository.findAll();
    }
}
