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
        ArrayList<HistoryDTO> historyDTOS = new ArrayList<>();
        ArrayList<Integer> games = new ArrayList<Integer>();
        if(histories.size() > 0) {
            for(int i = 0; i < histories.size(); i++)
            {
                if(!isInArray(games,histories.get(i).getGameId())) {
                    int gameId = histories.get(i).getGameId();
                    games.add(gameId);
                    HistoryDTO historyDTO = new HistoryDTO();
                    historyDTO.setGameid(gameId);
                    historyDTO.setWinner(histories.get(i).getWinner());
                    historyDTO.setTimestamp(histories.get(i).getDate());
                    for (GameHistory gh : histories) {
                        if(gh.getGameId() == gameId) {
                            User u = userRepository.findByUserId(gh.getUserId());
                            historyDTO.getUserLogins().add(u.getLogin());
                        }
                    }
                    historyDTOS.add(historyDTO);
                }
            }





            request.getSession().setAttribute("histories", historyDTOS);

        }
        return "history";
    }

    public boolean isInArray(ArrayList<Integer> array, int a){
        for(Integer i: array){
            if(i == a) return true;
        }
        return false;
    }
}
