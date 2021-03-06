package permutu.Models;

import java.util.ArrayList;

import java.util.Collections;
import java.util.LinkedList;


public class Room {

    private String  roomName;

    private Integer playersInRoom = 0;



    private int maxNumberOfPlayers=4;
    private int timeForGame=0;
    private int numberOfSymbols=24;

    private Permutu game;
    private Players players;

    public ArrayList<Player> getPlayers() {
        return players.getPlayers();
    }

    private LinkedList<Integer> order;

    private int mode;


    public Room(String roomName, Permutu game) {
        this.roomName = roomName;
        this.game = game;
        this.players = new Players();
        this.order = new LinkedList<>();
    }

    public int getMaxNumberOfPlayers() {
        return maxNumberOfPlayers;
    }

    public void setMaxNumberOfPlayers(int maxNumberOfPlayers) {
        this.maxNumberOfPlayers = maxNumberOfPlayers;
    }

    public int getTimeForGame() {
        return timeForGame;
    }

    public void setTimeForGame(int timeForGame) {
        this.timeForGame = timeForGame;
    }

    public int getNumberOfSymbols() {
        return numberOfSymbols;
    }

    public void setNumberOfSymbols(int numberOfSymbols) {
        this.numberOfSymbols = numberOfSymbols;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public void addPlayer(User user){
        if(players.size()<maxNumberOfPlayers)
        {
            players.addPlayer(user);
            playersInRoom++;
            order.addFirst(user.getUserId());
        }
        if(playersInRoom == maxNumberOfPlayers){
            if(mode == 2){
                Collections.shuffle(order);
            }
        }

    }


    /**
     * Usuwanie gracza opuszczającego pokój
     * @param player
     * @return
     */
    public boolean removePlayer(Player player){
        if(players.size()>0)
        {
            System.out.println("przed usuwaniem gracza, liczba graczy"+players.size());
            if(players.getPlayers().remove(player))
            {
                System.out.println("po usunieciu gracza, liczba graczy"+players.size());
                order.removeFirstOccurrence(player.getId());
                playersInRoom--;
                if(players.size()==0)
                {

                    resetRoom();
                }
                return true;
            }
            return false;
        }

        return false;
    }

    public Permutu getGame() {
        return game;
    }

    public void setGame(Permutu game) {
        this.game = game;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getPlayersInRoom() {
        return playersInRoom;
    }

    public void setPlayersInRoom(Integer playersInRoom) {
        this.playersInRoom = playersInRoom;
    }

    public String genereteHTMLtrForRoom(){
        String resultHTMLBlock = "<tr>" +
                "    <th scope=\"row\">1</th>" +
                "    <td>" + this.roomName + "</td>" +
                "    <td>" + this.playersInRoom + "</td>";
//        Jeżeli w pokoju nie ma jeszcze graczy mozna ustawić opcje pokoju
        if(players.size()==0)
        {
            resultHTMLBlock +=  "    <td>" +
                    "<select id=\"players\" name=\"players\" class=\"selectpicker show-tick\">\n" +
                    "  <option selected=\"selected\" value=\"4\">4 graczy</option>\n" +
                    "  <option value=\"2\">2 graczy</option>\n" +
                    "  <option value=\"1\">1 gracz</option>\n" +
                    "</select>" +
                    "</td>" +
                    "    <td>" +
                    "<select id=\"time\" name=\"time\" class=\"selectpicker show-tick\">\n" +
                    "  <option selected=\"selected\" value=\"0\">Nieograniczony</option>\n" +
                    "  <option value=\"1\">1 minuta</option>\n" +
                    "  <option value=\"5\">5 minut</option>\n" +
                    "  <option value=\"15\">15 minut</option>\n" +
                    "</select>" +
                    "</td>" +
                    "    <td>" +
                    "<select id=\"symbols\" name=\"symbols\" class=\"selectpicker show-tick\">\n" +
                    "  <option selected=\"selected\" value=\"24\">Wszystkie symbole</option>\n" +
                    "  <option value=\"10\">10 symboli</option>\n" +
                    "  <option value=\"20\">20 symboli</option>\n" +
                    "</select>" +
                    "</td>" +
                    "    <td>" +
                    "<select id=\"mode\" name=\"mode\" class=\"selectpicker show-tick\">\n" +
                    "  <option selected=\"selected\" value=\"1\">Kto pierwszy ten lepszy</option>\n" +
                    "  <option value=\"2\">Losowa kolejność</option>\n" +
                    "</select>" +
                    "</td>"
                    ;
        }else
        {
            resultHTMLBlock +=  "    <td>" +
                   + this.maxNumberOfPlayers +
                    "</td>" +
                    "    <td>";
            if(this.timeForGame==0)
            {
                resultHTMLBlock+= "Nie na czas";
            }else{
                resultHTMLBlock+=this.timeForGame+" min ";
            }
            resultHTMLBlock += "</td>" +
                    "    <td>" +
                     this.numberOfSymbols +
                    "</td>";
            if(mode == 1){
                resultHTMLBlock += "</td>" +
                        "    <td>" +
                        "Kto pierwszy ten lepszy" +
                        "</td>";
            }else{
                resultHTMLBlock += "</td>" +
                        "    <td>" +
                        "Losowa Kolejność" +
                "</td>";
            }

        }
        if(this.players.size()<maxNumberOfPlayers)
        {
            resultHTMLBlock +=  "    <td>" +
                    "        <button type=\"submit\" class=\"btn btn-primary\" id=\"roomName\" name=\"room\" value=\"" + this.roomName + "\"> Wybierz </button> " +
                    "</td>";
        }
       resultHTMLBlock+= "</tr>";
        return resultHTMLBlock;

    }

    public boolean isPlayer(String name){
        for(User u: this.getPlayers()){
            if(u.getLogin().equals(name)) return true;
        }
        return false;
    }

    public boolean isPlayerById(int id){
        for(Player p: this.getPlayers()){
            if(p.getId().equals(id)) return true;
        }
        return false;
    }

    public Player getPlayer(String name){
        for(Player p: this.getPlayers()){
            if(p.getLogin().equals(name)) return p;
        }
        return null;
    }

    public Player getPlayerById(int id){
        for(Player p: this.getPlayers()){
            if(p.getId().equals(id)) return p;
        }
        return null;
    }

    /**
     * Zmiana parametrów gry
     * @param players
     * @param time
     * @param symbols
     */
    public void setGameParameters(int players, int time, int symbols,int mode)
    {
        this.numberOfSymbols=symbols;
        this.timeForGame=time;
        this.maxNumberOfPlayers=players;
        this.game=new Permutu(numberOfSymbols);
        this.mode = mode;

    }

    /**
     * Resetowanie pokoju gdy wszyscy gracze opuszczą pokój
     */
    public void resetRoom(){
        System.out.println("Resetowanie rozgrywki "+roomName);
        this.maxNumberOfPlayers=4;
        this.timeForGame=0;
        this.numberOfSymbols=24;
        this.game=new Permutu();
        order = new LinkedList<>();
    }

    /**
     * Resetowanie pokoju gdy jedyny gracz pozostały w pokoju chce zresetować grę
     * @param p
     */
    public void resetRoom(Player p){
        System.out.println("Resetowanie rozgrywki i pozostawienie jednego gracza "+roomName);

        this.game=new Permutu(numberOfSymbols);
        p.resetPlayer();
    }

    public  String getWinner(){
        int max = 0;
        String winnerLogin = "";

        for (Player p : players.players) {
            if (p.getPoints() > max) {
                max = p.getPoints();
                winnerLogin = p.getLogin();
            }
        }
        return winnerLogin;
    }

    public void nextTurn(){
        Integer temp = order.removeLast();
        order.addFirst(temp);
    }

    public LinkedList<Integer> getOrder() {
        return order;
    }
}
