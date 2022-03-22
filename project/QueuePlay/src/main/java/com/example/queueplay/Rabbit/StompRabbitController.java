package com.example.queueplay.Rabbit;

import com.example.queueplay.Chat.ChatDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Log4j2
public class StompRabbitController {
    private final String exchangeName = "Queueplay.exchange";
    private final String queueName = "lobby";
    private final RabbitTemplate rabbitTemplate;


    @MessageMapping(value = "Queueplay.{lobbyId}")
    public void send(ChatDTO chatDto, @DestinationVariable Long lobbyId) {

        log.info("send lobby");
        rabbitTemplate.convertAndSend(exchangeName + "." + lobbyId.toString(), "", chatDto);
    }
}
