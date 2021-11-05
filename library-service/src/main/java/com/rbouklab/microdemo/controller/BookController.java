package com.rbouklab.microdemo.controller;

import com.rbouklab.microdemo.dto.BookDto;
import com.rbouklab.microdemo.model.Book;
import com.rbouklab.microdemo.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService bookService;

    @GetMapping("/")
    public List<Book> getAllBooks(){
        log.info("Get all books, BookController.getAllBooks");
        return bookService.getAllBooks();
    }

    @PostMapping("/")
    public Book addBook(@RequestBody final BookDto bookDto){
        log.info("Add new book, BookController.addBook");
        return bookService.addBook(bookDto);
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable final Long id){
        log.info("Get book by Id, BookController.getBookById");
        return bookService.getBookById(id);
    }
}
