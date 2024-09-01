package com.namtndev.identity_service.controller;

import com.namtndev.identity_service.dto.request.UserCreationRequest;
import com.namtndev.identity_service.dto.request.UserUpdateRequest;
import com.namtndev.identity_service.enity.User;
import com.namtndev.identity_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    User createUser(@RequestBody UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    User getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @DeleteMapping("/{userId}")
    String deleteUserById(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }
}
