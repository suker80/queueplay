package com.example.queueplay.Lobby;

import com.example.queueplay.Rabbit.RabbitService;
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
    private final RabbitService rabbitService;
    public static final String EXCHANGE_NAME = "Queueplay.exchange.";
    @PostMapping("/lobby")
    public void CreateLobby(@Valid @RequestBody LobbyCreateDto lobbyCreateDto) {
        Long aLong = lobbyService.create(lobbyCreateDto);
        rabbitService.addNewExchange(EXCHANGE_NAME  + aLong.toString());


    }
}
