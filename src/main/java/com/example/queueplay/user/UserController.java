package com.example.queueplay.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    public void join(@Valid @RequestBody UserJoinDto userJoinDto) {

        userService.join(userJoinDto);
    }

    @PostMapping("/user/name")
    public String changeName(@Valid @RequestBody UserNameChangeDto userNameChangeDto, @AuthenticationPrincipal User user) {

        return userService.changeName(userNameChangeDto.getName(), user);
    }

    @PostMapping("/user/picture")
    public void changePicture(@RequestParam MultipartFile file) throws IOException {

        userService.changePicture(file);

    }

}
