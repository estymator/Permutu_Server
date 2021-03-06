package permutu.Controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import permutu.Models.User;
import permutu.Repositories.UserRepository;
import permutu.Exceptions.*;

import java.security.Principal;
@Controller
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
                    @RequestParam int userRoleID){
        User u = new User();

        validRegisterData(login,email);


        u.setLogin(login);
        u.setEmail(email);
        u.setPassword(passwordEncoder.encode(password));
        u.setUserRoleId(1);
        u.setLogin(login);
        userRepository.save(u);
        System.out.println("Rejestracja " + u.getLogin());


        return u;

    }


    @PostMapping(path="admin/user/id")
    Iterable<User> findUserByLogin(@RequestParam String login)
    {
        System.out.println("User by login");
        return userRepository.findByLogin(login);
    }

    @PostMapping(path="admin/user/email")
    Iterable<User> findUserByEmail(@RequestParam String email)
    {
        System.out.println("User by email");
        return userRepository.findByEmail(email);
    }

    @GetMapping(path="/root")
    public @ResponseBody String sendRoot()
    {
        return "root";
    }


    /**
     * Function which validate register data, in case of problem, throw error
     * @param login - login from register form
     * @param email - email from register form
     */
    void validRegisterData(String login, String email)
    {
        if(findUserByLogin(login).toString()!="[]")
        {
            System.out.println("Istnieje juz taki login - "+login);
            throw new LoginAlreadyInUseException();

        }else if(findUserByEmail(email).toString()!="[]")
        {
            System.out.println("Konto z podanym adresem email już istnieje - "+email);
            throw new EmailAlreadyInUseException();
        }
    }
}


