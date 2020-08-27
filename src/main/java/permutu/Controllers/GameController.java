package permutu.Controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
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
             room.getGame().remove(b);
             playerBlocks.addBlock(b);
         }
        return "OK";
    }

    @MessageMapping("/leave")
    @SendTo("/play")
    public String leaveRoom(StreamMessageModel message) throws Exception {
        SingletonRooms rooms = SingletonRooms.getInstance();
        Room room = rooms.getPlayerRoom(message.getPlayerLogin());
        Player p = room.getPlayer(message.getPlayerLogin());
        if(room.removePlayer(p))
        {
            System.out.println("Remove "+p.getLogin());
        }else
        {
            System.out.println("Nie odnaleziono gracza");
        }
        System.out.println(room.getRoomName()+" "+p.getLogin());


        return p.getLogin()+" leaving room";
    }

    @MessageMapping("/reset")
    @SendTo("/play")
    public String resetGame(StreamMessageModel message) throws Exception {
        SingletonRooms rooms = SingletonRooms.getInstance();
        Room room = rooms.getPlayerRoom(message.getPlayerLogin());

        if(room.getPlayers().size()<=1)
        {
            room.resetRoom();
            return room.getRoomName()+" - reset room";
        }else
        {
            System.out.println("Nie można zresetować gry, zbyt wielu graczzy");
            return room.getRoomName()+" - Nie można zrestartowąć gry, co najmniej 2 graczy obecnych w pokoju";
        }




    }


}


