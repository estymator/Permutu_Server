package permutu.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import permutu.Models.User;
import permutu.Repositories.UserRepository;

import java.security.Principal;

@CrossOrigin
@RestController
public class MainController {
    @Autowired
    private UserRepository userRepository;

//    Encode password when register
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(path="/register")
    public @ResponseBody User addNewUser(@RequestParam String login,
                    @RequestParam String password,
                    @RequestParam String email,
                    @RequestParam int userRoleID,
                    @RequestParam int userRoleUrlID){
        User u = new User();

        u.setLogin(login);
        u.setEmail(email);
        u.setPassword(passwordEncoder.encode(password));
        u.setUserRoleId(userRoleID);
        u.setUserRoleId(userRoleUrlID);
        u.setLogin(login);
        userRepository.save(u);
        System.out.println("Rejestracja " + u.getLogin());
        return u;

    }



    Iterable<User> findUserByLogin(@RequestParam String login)
    {
        System.out.println("User login");
        return userRepository.findByLogin(login);
    }

    @GetMapping(path="/home")
    public @ResponseBody Iterable<User> sendHome(Principal principal)
    {
        System.out.println("/home "+principal.getName());
        return findUserByLogin(principal.getName());
    }


    @GetMapping(path="/error")
    public String errorPage()
    {
        System.out.println("Error");
        return "Error";
    }

    @GetMapping(path="/")
    public @ResponseBody String sendRoot()
    {
        return "root";
    }
}
