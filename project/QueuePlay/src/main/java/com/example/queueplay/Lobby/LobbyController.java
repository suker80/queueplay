package com.example.queueplay.Lobby;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class LobbyController {

    private final LobbyService lobbyService;
    @PostMapping("/lobby")
    public void CreateLobby(@Valid @RequestBody LobbyCreateDto lobbyCreateDto) {
        lobbyService.create(lobbyCreateDto);

    }
}
