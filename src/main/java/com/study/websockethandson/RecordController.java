package com.study.websockethandson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class RecordController {

    @MessageMapping("/game/{gameId}/record")
    @SendTo("/topic/game/{gameId}")
    public String message(@DestinationVariable Long gameId, Record record) {
        log.info("게임 ID: {}, 점수: {}, 선수: {}", gameId, record.score(), record.playerName());
        return record.playerName() + "이 " + record.score() + "점 얻었습니다!";
    }
}
