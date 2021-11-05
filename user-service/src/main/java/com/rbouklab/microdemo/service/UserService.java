package com.rbouklab.microdemo.service;

import com.rbouklab.microdemo.dto.UserDto;
import com.rbouklab.microdemo.model.User;
import com.rbouklab.microdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        log.info("Get all users, UserService.getAllUsers");
        return userRepository.findAll();
    }

    public User addUser(UserDto userDto) {
        log.info("Add new user, UserService.addUser");
        var user = new User(userDto.getCode(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        log.info("Get a user bu Id, UserService.getUserById");
        return userRepository.findById(id);
    }
}
