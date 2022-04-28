package com.example.queueplay.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class UserNameChangeDto implements Serializable {
    @NotBlank
    private final String name;
}
