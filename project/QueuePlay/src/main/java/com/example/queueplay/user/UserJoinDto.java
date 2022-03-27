package com.example.queueplay.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserJoinDto {
    @Email
    private String email;
    @NotBlank
    private String password;
}
