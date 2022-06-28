package com.example.queueplay.user;

import com.example.queueplay.user.dto.UserJoinRequest;
import com.example.queueplay.user.dto.UserNameChangeRequest;
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
    public void join(@Valid @RequestBody UserJoinRequest userJoinRequest) {

        userService.join(userJoinRequest);
    }

    @PostMapping("/user/name")
    public String changeName(@Valid @RequestBody UserNameChangeRequest userNameChangeRequest, @AuthenticationPrincipal User user) {

        return userService.changeName(userNameChangeRequest.getName(), user);
    }

    @PostMapping("/user/picture")
    public void changePicture(@RequestParam MultipartFile file) throws IOException {

        userService.changePicture(file);

    }

    @GetMapping("/user/test")
    public String test() {
        return "test";
    }
}
