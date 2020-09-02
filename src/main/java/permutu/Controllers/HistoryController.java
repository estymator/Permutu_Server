package permutu.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import permutu.Models.GameHistory;
import permutu.Models.HistoryDTO;
import permutu.Models.User;
import permutu.Repositories.GameHistoryRepository;
import permutu.Repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class HistoryController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    GameHistoryRepository gameHistoryRepository;

    @GetMapping("/history")
    public String getHistory(Principal principal, HttpServletRequest request) {
        String login = principal.getName();
        User user = userRepository.findUserByLogin(login);

        ArrayList<GameHistory> histories = gameHistoryRepository.findByUserId(user.getUserId());
        if(histories.size() > 0) {
            HistoryDTO historyDTO = new HistoryDTO();

            historyDTO.setGameid(histories.get(0).getGameId());
            historyDTO.setWinner(histories.get(0).getWinner());
            historyDTO.setTimestamp(histories.get(0).getDate());

            for (GameHistory gh : histories) {
                User u = userRepository.findByUserId(gh.getUserId());
                historyDTO.getUserLogins().add(u.getLogin());
            }


            request.getSession().setAttribute("histories", historyDTO);

        }
        return "history";
    }
}
