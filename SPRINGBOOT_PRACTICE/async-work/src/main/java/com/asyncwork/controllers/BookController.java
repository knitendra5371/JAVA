package com.asyncwork.controllers;

import com.asyncwork.models.Book;
import com.asyncwork.services.BookService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    private BookService bookService;

    @PostMapping("save")
    public ResponseEntity<Book> create(@RequestBody Book book) {
        Book result = bookService.create(book);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> update(@PathVariable int id, @RequestBody Book book) {
        Book book1 = bookService.fetchById(id);
        book.setId(id);
        Book result = bookService.update(book);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> fetchById(@PathVariable int id) {
        Book result = bookService.fetchById(id);
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<Book>> fetchAll() {
        List<Book> books = bookService.fetchAll();
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        bookService.delete(id);
    }
}
