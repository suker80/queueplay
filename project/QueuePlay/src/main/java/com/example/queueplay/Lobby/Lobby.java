package com.example.queueplay.Lobby;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Lobby {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

}
