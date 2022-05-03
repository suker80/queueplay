package com.example.queueplay.Lobby;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.io.Serializable;


public class LobbyPageDto implements Serializable {
    private final Long id;
    private final String name;
    private final String description;


    @QueryProjection
    public LobbyPageDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
