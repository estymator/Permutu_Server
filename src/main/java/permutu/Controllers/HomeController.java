package permutu.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import permutu.Models.*;
import permutu.Repositories.UserRepository;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private ServletContext servletContext;

    private SingletonRooms rooms = SingletonRooms.getInstance();
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/home")
    public String showHomeView(HttpServletRequest request, Model model) {
        if(request.getAttribute("rooms") == null) roomsFactory(request);
        return "home";
    }


    @GetMapping("/join")
    @ResponseBody
    public ModelAndView join(Principal principal,@RequestParam String room ) {
        String login = principal.getName();
        if(rooms.getRoom(room).isPlayer(login)){
            return new ModelAndView("redirect:" + "game");
        }
        else{
            User currentUser = userRepository.findUserByLogin(login);
            rooms.getRoom("Room_1").addPlayer(currentUser);
        }
        return new ModelAndView("redirect:" + "game");
    }

    private void roomsFactory(HttpServletRequest request){
        request.setAttribute("rooms",rooms);
    }

    public SingletonRooms getRooms() {
        return rooms;
    }

    public void setRooms(SingletonRooms rooms) {
        this.rooms = rooms;
    }
}
