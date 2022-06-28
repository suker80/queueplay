package com.example.queueplay.Chat;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ChatDTO {

    private Long id;
    private Long chatRoomId;
    private Long memberId;

    private String message;
    private String username;
}