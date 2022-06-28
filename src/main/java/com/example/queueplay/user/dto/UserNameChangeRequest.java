package com.example.queueplay.user.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class UserNameChangeRequest implements Serializable {
    @NotBlank
    private final String name;
}
