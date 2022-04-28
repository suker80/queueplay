package com.example.queueplay.Lobby;

import com.example.queueplay.Rabbit.RabbitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class LobbyControllerImpl implements LobbyControllerInterface {

    private final LobbyService lobbyService;
    private final RabbitService rabbitService;


    @Override
    public Long create() {
        Long lobbyId = lobbyService.create();
        return lobbyId;
    }

    @Override
    public void enter() {

    }

    @GetMapping("stomp")
    public String stomp() {
        return "stomp";
    }
}

