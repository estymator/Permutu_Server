package permutu.Controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import permutu.Models.*;
import permutu.Repositories.GameHistoryRepository;
import permutu.Repositories.GameModelRepository;


import permutu.Repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class HomeController {

    private final SingletonRooms rooms = SingletonRooms.getInstance();
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameModelRepository gameModelRepository;

    @Autowired
    GameHistoryRepository gameHistoryRepository;

    @GetMapping("/home")
    public String showHomeView(HttpServletRequest request) {
        if(request.getAttribute("rooms") == null) setRoomsAttribute(request);
        return "home";
    }


    @GetMapping("/join")
    @ResponseBody
    public ModelAndView join(HttpServletRequest request,Principal principal
                            ,@RequestParam String room
                            ,@RequestParam(required = false) Integer players
                            ,@RequestParam(required = false) Integer time
                            ,@RequestParam(required = false) Integer symbols) {
        String login = principal.getName();
        if(players != null && time!=null && symbols!=null && rooms.getRoom(room).getPlayers().size()<=1)
        {
            System.out.println("Zmiana parametrów pokoju");
            rooms.getRoom(room).setGameParameters(players, time,symbols);
        }
        if(rooms.getRoom(room).isPlayer(login)){
            System.out.println("User jest juz obecny w pokoju");
            return new ModelAndView("redirect:" + "game");
        }
        else{
            System.out.println("Dodanie usera do pokoju");
            User currentUser = userRepository.findUserByLogin(login);
            currentUser.incTotalGames();
            userRepository.save(currentUser);
            rooms.getRoom(room).addPlayer(currentUser);
            rooms.getRoom(room).getPlayer(login).setRoomName(room);
            request.getSession().setAttribute("room",room);
            request.getSession().setAttribute("player",login);
            System.out.println("Order - "+rooms.getRoom(room).getOrder());
        }
        return new ModelAndView("redirect:" + "game");
    }

    @PostMapping(path="/winner")
    public @ResponseBody String winner(@RequestParam String room, @RequestParam String winner){
        User u = userRepository.findUserByLogin(winner);
        u.incWinnGames();
        userRepository.save(u);
        GameModel game = new GameModel();
        gameModelRepository.save(game);

        game = gameModelRepository.findTopByOrderByIdDesc();

        Room currentRoom = rooms.getRoom(room);

        for(Player p : currentRoom.getPlayers()){
            GameHistory gameHistory = new GameHistory();
            gameHistory.setUserId(p.getId());
            gameHistory.setGameId(game.getId());
            gameHistory.setWinner(winner);
            gameHistoryRepository.save(gameHistory);
        }

        return winner;
    }


    private void setRoomsAttribute(HttpServletRequest request){
        request.setAttribute("rooms",rooms);
    }

}
