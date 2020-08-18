package permutu.Controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import permutu.Models.StreamMessageModel;


public class GameController {



    @MessageMapping("/game")
    @SendTo("/game")
    public StreamMessageModel send(StreamMessageModel message) throws Exception {
        return new StreamMessageModel(message.getGameId(), message.getPlayerId(), message.getMove());
    }
}
