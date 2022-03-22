package com.example.queueplay.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public void join(UserJoinDto userJoinDto) {
        userRepository.save(User.builder()
                .email(userJoinDto.getEmail())
                .password(passwordEncoder.encode(userJoinDto.getPassword()))
                .build());
    }
}
