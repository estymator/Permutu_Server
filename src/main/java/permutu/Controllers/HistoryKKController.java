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
        String in = mainBoard+playersBlocks;
        if (history != null && !history.isEmpty()) {
            System.out.println("wchodze");
            if (!in.equals(history.get(history.size() - 1))){
                history.add(in);
                game.setHistory(history);
                System.out.println("Saved move");
            } else {
                game.setHistory(history);
                System.out.println("MOVIE NOT SAVED");
            }
        } else {
            history.add(in);
            game.setHistory(history);
            System.out.println("Saved move");
        }
        //history.add(mainBoard+playersBlocks);
        return "idk";
    }

    @PostMapping(path = "/historyKKK")
    public @ResponseBody
    synchronized String his(@RequestParam String room, @RequestParam String direction){
        Permutu game = rooms.getRoom(room).getGame();
        int i = game.getStep();
        if(direction.equals("minus")){
            if ((i - 1)>0) {
                game.setStep(i-1);
                System.out.println("direction changed");
            }
        } else {
            if (i+1<game.getHistory().size()) {
                game.setStep(game.getStep() + 1);
                System.out.println("direction changed");
            }
        }
        return "idk";
    }
}
