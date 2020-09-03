package permutu.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import permutu.Models.User;
import permutu.Repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
@Controller
public class SettingsController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/settings")
    public ModelAndView showHomeView(HttpServletRequest request) {
        return new ModelAndView("settings");
    }

    @PostMapping(value="/change")
    public void  changeSettings(@RequestParam String inputLogin,
            @RequestParam String inputPassword4,
            @RequestParam String inputEmail4,
            @RequestParam String inputPassword24,
            @RequestParam String currentLogin){
        User u = userRepository.findUserByLogin(currentLogin);

        if(!inputLogin.isEmpty() && userRepository.findUserByLogin(inputLogin) == null){
            u.setLogin(inputLogin);
        }
        if(!inputEmail4.isEmpty() && userRepository.findByEmail(inputEmail4).getClass() == null){
            u.setEmail(inputEmail4);
        }
        if(!inputPassword4.isEmpty() && inputPassword4.equals(inputPassword24)){
            u.setPassword(passwordEncoder.encode(inputPassword4));
        }
        userRepository.save(u);


    }

}
