package com.bookStore.bookStore.controller;
import com.bookStore.bookStore.entity.Book;
import com.bookStore.bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    //get all the books
    @GetMapping(value = "/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    @GetMapping(value = "/books/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @PostMapping(value = "/add")
    public void addBook(@RequestBody Book book){
        bookRepository.save(book);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteBook(@PathVariable int id){
        Book book = bookRepository.findById(id).orElse(null);
        bookRepository.delete(book);
    }

}
