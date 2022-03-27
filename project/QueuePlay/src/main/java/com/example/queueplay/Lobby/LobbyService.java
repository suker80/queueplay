package com.example.queueplay.Lobby;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LobbyService {

    private final LobbyRepository lobbyRepository;


    public Long create() {
        Lobby lobby = new Lobby();
        Lobby save = lobbyRepository.save(lobby);
        return save.getId();
    }
}
