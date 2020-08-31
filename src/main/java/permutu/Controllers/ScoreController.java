package permutu.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import permutu.Models.User;
import permutu.Repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class ScoreController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/score")
    public String showScoreView(HttpServletRequest request, Model model) {
        ArrayList<User> users = userRepository.findAll();
        request.getSession().setAttribute("users",users);
        return "scores";
    }
}
