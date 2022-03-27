package com.example.queueplay.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    public void join(@Valid @RequestBody UserJoinDto userJoinDto) {

        userService.join(userJoinDto);
    }

    @PostMapping("/user/change")
    public String changeName(@Valid @RequestBody UserNameChangeDto userNameChangeDto, @AuthenticationPrincipal User user) {

        return userService.changeName(userNameChangeDto.getName(),user);
    }

}
