package permutu.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginView {
    private static final String LOGIN_VIEW = "logowanie";
    private static final String REGISTER_VIEW = "rejestracja";

    @GetMapping("/login")
    public String showLoginView(Model model) {

        return LOGIN_VIEW;
    }

    @GetMapping("/register")
    public String showRegisterView(Model model) {

        return REGISTER_VIEW;
    }
}
