package com.rbouklab.microdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;
    private String category;
    private String author;

    public Book(String title, String isbn, String category, String author) {
        this.title = title;
        this.isbn = isbn;
        this.category = category;
        this.author = author;
    }
}
