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

        ArrayList<GameHistory> histories = gameHistoryRepository.findAll();
        ArrayList<GameHistory> userGames = gameHistoryRepository.findByUserId(user.getUserId());

        ArrayList<Integer> userGamesId = new ArrayList<>();

        for(GameHistory gh : userGames){
            userGamesId.add(gh.getGameId());
        }



        ArrayList<HistoryDTO> historyDTOS = new ArrayList<>();

        ArrayList<Integer> saved = new ArrayList<>();

        for(GameHistory gh: histories){
            if(isInArray(userGamesId,gh.getGameId()) && !isInArray(saved,gh.getGameId())){
                HistoryDTO historyDTO = new HistoryDTO(gh.getDate(),gh.getWinner(), gh.getGameId(), gh.getMode(), gh.getSymbols(), gh.getTime());
                for(GameHistory ghh : histories){
                    if(gh.getGameId().intValue() == ghh.getGameId().intValue()){
                        User tempUser = userRepository.findByUserId(ghh.getUserId());
                        historyDTO.getUserLogins().add(tempUser.getLogin());
                    }
                }
                saved.add(gh.getGameId());
                historyDTOS.add(historyDTO);
            }
        }


        request.getSession().setAttribute("histories", historyDTOS);


        return "history";
    }

    public boolean isInArray(ArrayList<Integer> array, int a){
        for(Integer i: array){
            if(i == a) return true;
        }
        return false;
    }

    private boolean isInList(ArrayList<Integer> array,int i){
        for(Integer el : array){
            if(el == i) return true;
        }
        return false;
    }
}
