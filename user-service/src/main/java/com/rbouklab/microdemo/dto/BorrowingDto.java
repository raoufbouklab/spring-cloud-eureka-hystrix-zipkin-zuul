package com.rbouklab.microdemo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BorrowingDto {
    private Long userId;
    private Long bookId;
}