package com.example.queueplay.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${file.dir}")
    private String fileDir;

    public void join(UserJoinDto userJoinDto) {
        userRepository.save(User.builder()
                .email(userJoinDto.getEmail())
                .password(passwordEncoder.encode(userJoinDto.getPassword()))
                .role("ROLE_User")
                .build());
    }

    public String changeName(String newName, User user) {
        return user.changeName(newName);
    }

    public void changePicture(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        String ext = filename.substring(filename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();


        String fullPath = fileDir + uuid + "." + ext;
        InputStream inputStream = file.getInputStream();


    }
}
