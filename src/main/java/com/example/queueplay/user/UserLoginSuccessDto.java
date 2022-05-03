package com.example.queueplay.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginSuccessDto implements Serializable {
    private final Long id;
    private final String name;
    private final String picture;
}
