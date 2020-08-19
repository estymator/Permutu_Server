package permutu.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import permutu.Models.User;
import permutu.Repositories.UserRepository;

import java.security.Principal;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping(path="/user/all")
    public @ResponseBody
    Iterable<User> getAll()
    {
        System.out.println("user/all");
        return userRepository.findAll();
    }
}
