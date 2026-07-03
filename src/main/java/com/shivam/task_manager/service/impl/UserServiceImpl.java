package com.shivam.task_manager.service.impl;

import com.shivam.task_manager.dto.UserDTO;
import com.shivam.task_manager.exception.UserAlreadyExistsException;
import com.shivam.task_manager.model.Users;
import com.shivam.task_manager.repository.UserRepository;
import com.shivam.task_manager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public void signUpUser(UserDTO userDTO) {

        if (userRepository.existsByUsername(userDTO.getUsername())) {
            throw new UserAlreadyExistsException();
        }

        Users user = new Users();
        user.setUsername(userDTO.getUsername());
        user.setPassword(encoder.encode(userDTO.getPassword()));

        userRepository.save(user);
    }
}
