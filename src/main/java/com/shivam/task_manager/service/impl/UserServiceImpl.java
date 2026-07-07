package com.shivam.task_manager.service.impl;

import com.shivam.task_manager.dto.UserDTO;
import com.shivam.task_manager.exception.UsernameAlreadyExistsException;
import com.shivam.task_manager.model.Users;
import com.shivam.task_manager.repository.UserRepository;
import com.shivam.task_manager.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    private final AuthenticationManager authenticationManager;
    private final JwtServiceImpl jwtService;

    @Override
    public void signUpUser(UserDTO userDTO) {

        if (userRepository.existsByUsername(userDTO.getUsername())) {
            throw new UsernameAlreadyExistsException();
        }

        Users user = new Users();
        user.setUsername(userDTO.getUsername());
        user.setPassword(encoder.encode(userDTO.getPassword()));

        userRepository.save(user);
    }

    @Override
    public Map<String, String> signInUser(UserDTO userDTO) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));
        Map<String, String> signInResponseMap = new HashMap<>();
        Users user = userRepository.findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("User with username " + userDTO.getUsername() + " not found."));
        signInResponseMap.put("userId", String.valueOf(user.getId()));
        signInResponseMap.put("username", userDTO.getUsername());
        signInResponseMap.put("jwt", jwtService.generateToken(userDTO.getUsername()));

        return signInResponseMap;
    }
}