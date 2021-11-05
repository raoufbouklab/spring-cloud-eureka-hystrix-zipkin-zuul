package com.rbouklab.microdemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto {
    private String title;
    private String isbn;
    private String category;
    private String author;
}
