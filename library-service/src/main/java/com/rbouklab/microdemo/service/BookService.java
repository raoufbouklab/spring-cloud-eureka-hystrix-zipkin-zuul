package com.rbouklab.microdemo.service;

import com.rbouklab.microdemo.dto.BookDto;
import com.rbouklab.microdemo.model.Book;
import com.rbouklab.microdemo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        log.info("Get all books, BookService.getAllBooks");
        return bookRepository.findAll();
    }

    public Book addBook(BookDto bookDto) {
        log.info("Add new book, BookService.addBook");
        var book = new Book(bookDto.getTitle(), bookDto.getIsbn(), bookDto.getCategory(), bookDto.getAuthor());
        return bookRepository.save(book);
    }

    public Optional<Book> getBookById(Long id) {
        log.info("Get book by Id, BookService.getBookById");
        return bookRepository.findById(id);
    }
}
