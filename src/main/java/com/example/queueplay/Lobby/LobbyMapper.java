package com.example.queueplay.Lobby;

import org.mapstruct.*;

@Mapper( componentModel = "spring")
public interface LobbyMapper {

    Lobby lobbyCreateDtoToLobby(LobbyCreateDto lobbyCreateDto);

    LobbyCreateDto lobbyToLobbyCreateDto(Lobby lobby);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLobbyFromLobbyCreateDto(LobbyCreateDto lobbyCreateDto, @MappingTarget Lobby lobby);
}
