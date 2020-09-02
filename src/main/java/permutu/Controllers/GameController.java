package permutu.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import permutu.Models.*;
import permutu.Repositories.GameHistoryRepository;
import permutu.Repositories.GameModelRepository;
import permutu.Repositories.UserRepository;

@Controller
public class GameController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameModelRepository gameModelRepository;

    @Autowired
    private GameHistoryRepository gameHistoryRepository;

    private SingletonRooms rooms = SingletonRooms.getInstance();

    @GetMapping("/game")
    public String showLoginView(Model model) {

        return "game";
    }
    @GetMapping("/")
    public String showView(Model model) {

        return "index";
    }



    @MessageMapping("/move")
    @SendTo("/play")
    public String play(StreamMessageModel message) throws Exception {
        Room room = rooms.getPlayerRoom(message.getPlayerLogin());
        Player p = room.getPlayer(message.getPlayerLogin());
        if(room.getPlayers().size()<room.getMaxNumberOfPlayers())
        {
            return "Nie można zacząć gry dopóki wszystkie miejsca nie będą zajęte";
        }
        BlockCollection playerBlocks = p.getBlocksInHand();
        BlockCollection selectedBlocks =  new BlockCollection("selectedBlocks");
        if(message.getselectedBlocks().length > 0){
            for(String s : message.getselectedBlocks())
            selectedBlocks.addBlock(new Block(s));
        }

        if(message.getselectedBlocks().length == 1){
            if(room.getGame().isInFullColumn(selectedBlocks.getBlock(0)) && room.getGame().haventAnyPlayer(room.getPlayers(),selectedBlocks.getBlock(0),p)){
                room.getGame().removeFromBoard(selectedBlocks.getBlock(0));
                playerBlocks.addBlockOrdered(selectedBlocks.getBlock(0));

            }
        }

        else if(room.getGame().checkWhetherIsFromThisSameColumn(selectedBlocks)) {
            if (room.getGame().playerHaveAllSignFromColumn(p, selectedBlocks) || room.getGame().playerDontHaveOneSignFromThisColumn(p,selectedBlocks)) {
                for (Block b : selectedBlocks.getBlocks()) {
                    room.getGame().removeFromBoard(b);
                    playerBlocks.addBlockOrdered(b);
                }

            }
        }
        p.countPoints();
        room.nextTurn();
        System.out.println(room.getOrder());
        return "OK";
    }

    @MessageMapping("/leave")
    @SendTo("/play")
    public String leaveRoom(StreamMessageModel message) throws Exception {

        Room room = rooms.getPlayerRoom(message.getPlayerLogin());
        Player p = room.getPlayer(message.getPlayerLogin());

        if(room.removePlayer(p))
        {
            System.out.println("Remove "+p.getLogin());
        }else
        {
            System.out.println("Nie odnaleziono gracza");
        }



        return p.getLogin()+" leaving room";
    }

    @MessageMapping("/reset")
    @SendTo("/play")
    public String resetGame(StreamMessageModel message) throws Exception {
        SingletonRooms rooms = SingletonRooms.getInstance();
        Room room = rooms.getPlayerRoom(message.getPlayerLogin());
        User currentUser = userRepository.findUserByLogin(message.getPlayerLogin());

        if(room.getPlayers().size()==1)
        {
            if(message.getPlayerLogin()!=null)
            {


                Player p = room.getPlayer(message.getPlayerLogin());
                room.resetRoom(p);
                return room.getRoomName()+" - reset room";
            }else {
                System.out.println("/reset - nie zidentyfikowano gracza");
                return "Error";
            }
        }else
        {
            System.out.println("Nie można zresetować gry, zbyt wielu graczzy");
            return room.getRoomName()+" - Nie można zrestartowąć gry, co najmniej 2 graczy obecnych w pokoju";
        }

    }


    /**
     * Simple method to let others users know about new user in room
     * @param message
     * @return
     * @throws Exception
     */
    @MessageMapping("/knock")
    @SendTo("/play")
    public String newUserConnect(StreamMessageModel message) throws Exception {
     return "New user joined";
    }

    @PostMapping(path="/winner")
    public @ResponseBody
    synchronized String winner(@RequestParam String room, @RequestParam String winner){
        Permutu game = rooms.getRoom(room).getGame();
        Room currentRoom = rooms.getRoom(room);

        if(!game.isSaved()){

            User u = userRepository.findUserByLogin(winner);
            u.incWinnGames();
            userRepository.save(u);

            GameModel gameModel = new GameModel();
            gameModelRepository.save(gameModel);

            gameModel = gameModelRepository.findTopByOrderByIdDesc();

            gameModel.setMaxNumberOfPlayers(currentRoom.getMaxNumberOfPlayers());
            gameModel.setNumberOfSymbols(currentRoom.getNumberOfSymbols());
            gameModel.setTimeForGame(currentRoom.getTimeForGame());


            for(Player p : currentRoom.getPlayers()){
                GameHistory gameHistory = new GameHistory();
                gameHistory.setUserId(p.getId());
                gameHistory.setGameId(gameModel.getId());
                gameHistory.setWinner(winner);
                gameHistoryRepository.save(gameHistory);
            }
            game.setSaved(true);
        }
        return winner;
    }


}


