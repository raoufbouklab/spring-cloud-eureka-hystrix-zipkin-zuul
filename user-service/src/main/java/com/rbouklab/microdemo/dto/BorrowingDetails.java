package com.rbouklab.microdemo.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BorrowingDetails {
    private UserDto userDto;
    private BookDto bookDto;
    private LocalDate borrowingDate;
    private LocalDate returnDate;
}