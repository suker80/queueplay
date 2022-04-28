package com.example.queueplay.song;

import com.example.queueplay.Lobby.Lobby;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "lobby_id")
    private Lobby lobby;


}
