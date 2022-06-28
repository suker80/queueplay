package com.example.queueplay.user.dto;

import lombok.Data;

@Data
public class UserLoginSuccessResponse {
    private final Long id;
    private final String name;
    private final String picture;
}
