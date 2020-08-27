package permutu.Controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import permutu.Models.*;

@Controller
public class GameController {


    @GetMapping("/game")
    public String showLoginView(Model model) {

        return "game";
    }
    @GetMapping("/")
    public String showView(Model model) {

        return "index";
    }

    @MessageMapping("/move")
    @SendTo("/play")
    public String play(StreamMessageModel message) throws Exception {
        SingletonRooms rooms = SingletonRooms.getInstance();
        Room room = rooms.getPlayerRoom(message.getPlayerLogin());
        Player p = room.getPlayer(message.getPlayerLogin());
        BlockCollection playerBlocks = p.getBlocksInHand();
         for(String s: message.getselectedBlocks()){
             Block b = new Block(s);
             //room.getGame().remove(b);
             room.getGame().removeFromBoard(b);
             //playerBlocks.addBlock(b);
             playerBlocks.addBlockOrdered(b);
         }
        return "OK";
    }

}


