package permutu.Controllers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginViewController {
    private static final String LOGIN_VIEW = "logowanie";
    private static final String REGISTER_VIEW = "rejestracja";
    private static final String HOME_VIEW = "home";

    @GetMapping("/login")
    public String showLoginView(Model model) {
        if (isAuthenticated()) {
            return "redirect:/home";
        }
        return LOGIN_VIEW;
    }


    @GetMapping("/register")
    public String showRegisterView(Model model) {
        if (isAuthenticated()) {

            return "redirect:/home";
        }
        return REGISTER_VIEW;
    }

    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
                isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }
}
