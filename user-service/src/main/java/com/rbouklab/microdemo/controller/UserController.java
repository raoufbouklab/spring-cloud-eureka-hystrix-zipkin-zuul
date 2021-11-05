package com.rbouklab.microdemo.controller;

import com.rbouklab.microdemo.dto.UserDto;
import com.rbouklab.microdemo.model.User;
import com.rbouklab.microdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers() {
        log.info("Get all users, UserController.getAllUsers");
        return userService.getAllUsers();
    }

    @PostMapping("/")
    public User addUser(@RequestBody final UserDto userDto) {
        log.info("Add new User, UserController.addUser");
        return userService.addUser(userDto);
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable final Long id) {
        log.info("Get user by Id, UserController.getUserById");
        return userService.getUserById(id);
    }
}
