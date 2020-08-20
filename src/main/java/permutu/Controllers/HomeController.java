package permutu.Controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import permutu.Models.StreamMessageModel;

@Controller
public class HomeController {


    @GetMapping("/home")
    public String showHomeView(Model model) {
        return "home";
    }

}
