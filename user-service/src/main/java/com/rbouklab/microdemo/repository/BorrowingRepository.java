package com.rbouklab.microdemo.repository;

import com.rbouklab.microdemo.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
}
