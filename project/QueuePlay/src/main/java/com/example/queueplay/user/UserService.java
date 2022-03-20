package com.example.queueplay.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void join(UserJoinDto userJoinDto) {
        userRepository.save(User.builder()
                .email(userJoinDto.getEmail())
                .password(userJoinDto.getPassword())
                .build());
    }
}
