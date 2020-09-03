package permutu.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import permutu.Models.Permutu;
import permutu.Models.SingletonRooms;

import java.util.ArrayList;

@Controller
public class HistoryKKController {

    private SingletonRooms rooms = SingletonRooms.getInstance();

    @PostMapping(path = "/historyKK")
    public @ResponseBody
    synchronized String his(@RequestParam String room, @RequestParam String mainBoard, @RequestParam String playersBlocks){
        Permutu game = rooms.getRoom(room).getGame();
        ArrayList<String>history = game.getHistory();
        history.add(mainBoard);
        game.setHistory(history);
        System.out.println("?????????");
        return "idk";
    }
}
