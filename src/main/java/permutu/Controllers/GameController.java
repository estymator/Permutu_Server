package permutu.Controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import permutu.Models.StreamMessageModel;

@Controller
public class GameController {


    @GetMapping("/game")
    public String showLoginView(Model model) {

        return "game";
    }
/*
    @MessageMapping("/game")
    @SendTo("/game")
    public StreamMessageModel send(StreamMessageModel message) throws Exception {
        return new StreamMessageModel(message.getGameId(), message.getPlayerId(), message.getMove());
    }
    */

}