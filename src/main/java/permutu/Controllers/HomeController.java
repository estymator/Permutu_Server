package permutu.Controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import permutu.Models.*;
import permutu.Repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class HomeController {

    private final SingletonRooms rooms = SingletonRooms.getInstance();
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/home")
    public String showHomeView(HttpServletRequest request) {
        if(request.getAttribute("rooms") == null) setRoomsAttribute(request);
        return "home";
    }


    @GetMapping("/join")
    @ResponseBody
    public ModelAndView join(HttpServletRequest request,Principal principal,@RequestParam String room ) {
        String login = principal.getName();
        if(rooms.getRoom(room).isPlayer(login)){
            return new ModelAndView("redirect:" + "game");
        }
        else{
            User currentUser = userRepository.findUserByLogin(login);
            currentUser.incTotalGames();
            userRepository.save(currentUser);
            rooms.getRoom(room).addPlayer(currentUser);
            rooms.getRoom(room).getPlayer(login).setRoomName(room);
            request.getSession().setAttribute("room",room);
            request.getSession().setAttribute("player",login);
            System.out.println(rooms.getRoom(room).getOrder());
        }
        return new ModelAndView("redirect:" + "game");
    }

    @PostMapping(path="/winner")
    public @ResponseBody void addNewUser(@RequestParam String winner){
        User u = userRepository.findUserByLogin(winner);
        u.incWinnGames();
        userRepository.save(u);
    }


    private void setRoomsAttribute(HttpServletRequest request){
        request.setAttribute("rooms",rooms);
    }

}
