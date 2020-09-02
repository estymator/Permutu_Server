package permutu.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
@Controller
public class SamouczekController {

    @GetMapping("/samouczek")
    public ModelAndView showHomeView(HttpServletRequest request) {
        return new ModelAndView("samouczek");
    }
}
