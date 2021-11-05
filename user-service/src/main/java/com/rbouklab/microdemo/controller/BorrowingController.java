package com.rbouklab.microdemo.controller;

import com.rbouklab.microdemo.dto.BorrowingDetails;
import com.rbouklab.microdemo.dto.BorrowingDto;
import com.rbouklab.microdemo.model.Borrowing;
import com.rbouklab.microdemo.service.BorrowingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
@Slf4j
public class BorrowingController {

    private final BorrowingService borrowingService;

    @GetMapping("/")
    public List<Borrowing> getAllBorrowings() {
        log.info("Get all borrowings, BorrowingController.getAllBorrowings");
        return borrowingService.getAllBorrowings();
    }

    @PostMapping("/")
    public BorrowingDetails borrowBook(@RequestBody final BorrowingDto borrowingDto) {
        log.info("Borrow a book, BorrowingController.borrowBook");
        return borrowingService.borrowBook(borrowingDto);
    }
}
