package permutu.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SettingsController {

    @GetMapping("/settings")
    public String showHomeView(HttpServletRequest request) {
        return "settings";
    }

}
