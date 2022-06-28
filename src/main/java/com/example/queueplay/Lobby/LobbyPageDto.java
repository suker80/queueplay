package com.example.queueplay.Lobby;

import lombok.Data;

import java.io.Serializable;


@Data
public class LobbyPageDto implements Serializable {
    private final Long id;
    private final String name;
    private final String description;


    public LobbyPageDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

}
