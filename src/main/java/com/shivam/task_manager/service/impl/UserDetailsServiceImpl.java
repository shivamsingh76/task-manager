package com.shivam.task_manager.service.impl;

import com.shivam.task_manager.model.Users;
import com.shivam.task_manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = userRepository.findByUsername(username);

        if(user.isEmpty()) {
            System.out.println("User not found.");
            throw new UsernameNotFoundException("User not found.");
        }

        return new UserDetailsImpl(user.get());
    }
}
