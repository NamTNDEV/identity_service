package com.namtndev.identity_service.controller;

import com.namtndev.identity_service.dto.request.UserCreationRequest;
import com.namtndev.identity_service.dto.request.UserUpdateRequest;
import com.namtndev.identity_service.dto.response.ApiResponse;
import com.namtndev.identity_service.enity.User;
import com.namtndev.identity_service.libs.HttpStatus;
import com.namtndev.identity_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> response = new ApiResponse<>();
        response.setCode(HttpStatus.SUCCESS_CREATED.getCode());
        response.setMessage(HttpStatus.SUCCESS_CREATED.getMessage());
        response.setData(userService.createUser(request));
        return response;
    }

    @GetMapping
    ApiResponse<List<User>> getAllUsers() {
        ApiResponse<List<User>> response = new ApiResponse<>();
        response.setCode(HttpStatus.SUCCESS_OK.getCode());
        response.setMessage(HttpStatus.SUCCESS_OK.getMessage());
        response.setData(userService.getAllUsers());
        return response;
    }

    @GetMapping("/{userId}")
    ApiResponse getUserById(@PathVariable String userId) {
        ApiResponse<User> response = new ApiResponse<>();
        response.setCode(HttpStatus.SUCCESS_OK.getCode());
        response.setMessage(HttpStatus.SUCCESS_OK.getMessage());
        response.setData(userService.getUserById(userId));
        return response;
    }

    @DeleteMapping("/{userId}")
    ApiResponse deleteUserById(@PathVariable String userId) {
        ApiResponse response = new ApiResponse<>();
        response.setCode(HttpStatus.SUCCESS_OK.getCode());
        response.setMessage(HttpStatus.SUCCESS_OK.getMessage());
        return response;
    }

    @PutMapping("/{userId}")
    ApiResponse updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        ApiResponse<User> response = new ApiResponse<>();
        response.setCode(HttpStatus.SUCCESS_OK.getCode());
        response.setMessage(HttpStatus.SUCCESS_OK.getMessage());
        response.setData(userService.updateUser(userId, request));
        return response;
    }
}
