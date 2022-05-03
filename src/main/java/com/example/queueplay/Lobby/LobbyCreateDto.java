package com.example.queueplay.Lobby;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class LobbyCreateDto {
    private String name;
    private String description;
}
