package com.shivam.task_manager.controller;

import com.shivam.task_manager.dto.UserDTO;
import com.shivam.task_manager.response.ResponseHandler;
import com.shivam.task_manager.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    ResponseEntity<Object> signupUser(@Valid @RequestBody UserDTO userDTO) {

        userService.signUpUser(userDTO);
        return ResponseHandler.handleResponse(HttpStatus.CREATED, "Sign up successful.", null);
    }
}
