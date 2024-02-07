package com.bookStore.bookStore.controller;
import com.bookStore.bookStore.entity.Book;
import com.bookStore.bookStore.repository.BookRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;

@Controller
    public class BookController {

        @Autowired
        private BookRepository bookRepository;

        @GetMapping(value = "/books")
        public List<Book> getAllBooks() {
            return bookRepository.findAll();
        }

        @GetMapping("update/{id}")
        public Book getBookById(@PathVariable Integer id) {
            return bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid book id"+ id));
        }

        @PostMapping(value = "/save")
        public Book addBook(@RequestBody Book book) {
            return bookRepository.save(book);

        }

        @DeleteMapping("delete/{id}")
        public void deleteBook(@PathVariable Integer id) {
            bookRepository.deleteById(id);
        }
    }

