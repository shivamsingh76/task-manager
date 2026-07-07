package com.shivam.task_manager.service;

import com.shivam.task_manager.dto.UserDTO;

import java.util.Map;

public interface UserService {
    void signUpUser(UserDTO userDTO);

    Map<String, String> signInUser(UserDTO userDTO);
}
