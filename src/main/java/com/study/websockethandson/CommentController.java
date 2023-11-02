package com.study.websockethandson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class CommentController {

    @MessageMapping("/game/{gameId}/comment")
    @SendTo("/topic/game/{gameId}")
    public Comment message(@DestinationVariable Long gameId, Comment comment) {
        log.info("게임 ID: {}, 댓글: {}", gameId, comment.content());
        return comment;
    }
}
