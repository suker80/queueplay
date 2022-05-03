package com.example.queueplay.Lobby;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LobbyService {

    private final LobbyRepository lobbyRepository;
    private final LobbyMapper mapper;


    public Long create() {
        Lobby lobby = new Lobby();
        Lobby save = lobbyRepository.save(lobby);
        return save.getId();
    }

    public Long create(LobbyCreateDto lobbyCreateDto) {
        Lobby lobby = mapper.lobbyCreateDtoToLobby(lobbyCreateDto);
        lobbyRepository.save(lobby);
        return lobby.getId();
    }

    public Page<Lobby> pageLobby(Pageable pageable) {

        return lobbyRepository.findAll(pageable);
    }

}
