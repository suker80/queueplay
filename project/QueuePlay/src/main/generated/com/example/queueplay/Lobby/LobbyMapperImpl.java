package com.example.queueplay.Lobby;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-28T18:55:14+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class LobbyMapperImpl implements LobbyMapper {

    @Override
    public Lobby lobbyCreateDtoToLobby(LobbyCreateDto lobbyCreateDto) {
        if ( lobbyCreateDto == null ) {
            return null;
        }

        Lobby lobby = new Lobby();

        return lobby;
    }

    @Override
    public LobbyCreateDto lobbyToLobbyCreateDto(Lobby lobby) {
        if ( lobby == null ) {
            return null;
        }

        LobbyCreateDto lobbyCreateDto = new LobbyCreateDto();

        lobbyCreateDto.setName( lobby.getName() );
        lobbyCreateDto.setDescription( lobby.getDescription() );

        return lobbyCreateDto;
    }

    @Override
    public void updateLobbyFromLobbyCreateDto(LobbyCreateDto lobbyCreateDto, Lobby lobby) {
        if ( lobbyCreateDto == null ) {
            return;
        }
    }
}
