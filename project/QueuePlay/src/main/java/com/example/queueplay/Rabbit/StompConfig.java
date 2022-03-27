package com.example.queueplay.Rabbit;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class StompConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/stomp/chat")
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        registry.setPathMatcher(new AntPathMatcher(".")); //
        registry.setApplicationDestinationPrefixes("/pub");


        registry.enableStompBrokerRelay("/queue", "/topic", "/exchange", "/amq/queue")
                .setRelayPort(61613)
                .setRelayHost("127.0.0.1")
                .setClientLogin("guest")
                .setClientPasscode("guest");
    }

}