package com.example.queueplay.Lobby;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static com.example.queueplay.Lobby.QLobby.lobby;
import static org.junit.jupiter.api.Assertions.*;

class CustomLobbyRepositoryImplTest {

    private final QLobby qLobby = lobby;
    @Autowired
    private LobbyRepository lobbyRepository;
    @PersistenceContext
    EntityManager em;
    private final JPAQueryFactory queryFactory = new JPAQueryFactory(em);

    @BeforeEach
    public void initLobby() {
        for (int i = 0; i < 50; i++) {
            Lobby lobby = new Lobby("Lobby" + i, "Lobby" + i);
            lobbyRepository.save(lobby);
        }

    }

    @Test
    public void PageLobby() {

        List<Lobby> fetch = queryFactory.selectFrom(lobby).fetch();

    }

}