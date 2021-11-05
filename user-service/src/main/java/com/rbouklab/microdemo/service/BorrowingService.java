package com.rbouklab.microdemo.service;

import com.rbouklab.microdemo.dto.BookDto;
import com.rbouklab.microdemo.dto.BorrowingDetails;
import com.rbouklab.microdemo.dto.BorrowingDto;
import com.rbouklab.microdemo.dto.UserDto;
import com.rbouklab.microdemo.exception.UserOrBookNotFoundException;
import com.rbouklab.microdemo.model.Borrowing;
import com.rbouklab.microdemo.repository.BorrowingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BorrowingService {

    private final BorrowingRepository borrowingRepository;

    private final UserService userService;

    private final RestTemplate restTemplate;

    public List<Borrowing> getAllBorrowings() {
        log.info("get all borrowing books, BorrowingService.getAllBorrowings");
        return borrowingRepository.findAll();
    }

    public BorrowingDetails borrowBook(BorrowingDto borrowingDto) {
        log.info("Borrow a book, BorrowingService.borrowBook");
        var user = userService.getUserById(borrowingDto.getUserId());
        var bookDto = Optional.ofNullable(restTemplate.getForObject("http://LIBRARY-SERVICE/books/" + borrowingDto.getBookId(), BookDto.class));

        if (user.isPresent() && bookDto.isPresent()) {
            var currentDate = LocalDate.now();
            var borrowing = new Borrowing(borrowingDto.getUserId(), borrowingDto.getBookId(), currentDate, currentDate.plusWeeks(3));
            borrowingRepository.save(borrowing);
            return BorrowingDetails.builder()
                    .userDto(UserDto.builder()
                            .code(user.get().getCode())
                            .firstName(user.get().getFirstName())
                            .lastName(user.get().getLastName())
                            .email(user.get().getEmail())
                            .build())
                    .bookDto(bookDto.get())
                    .borrowingDate(borrowing.getBorrowingDate())
                    .returnDate(borrowing.getReturnDate())
                    .build();
        }
        throw new UserOrBookNotFoundException("Can't borrow this book, User or Book not found");
    }
}
