package com.rbouklab.microdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "borrowings")
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private Long bookId;
    private LocalDate borrowingDate;
    private LocalDate returnDate;

    public Borrowing(Long userId, Long bookId, LocalDate borrowingDate, LocalDate returnDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.borrowingDate = borrowingDate;
        this.returnDate = returnDate;
    }
}
