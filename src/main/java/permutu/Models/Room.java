package permutu.Models;


import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Stack;

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

    public void addPlayer(User user){
        if(players.size()<maxNumberOfPlayers)
        {
            players.addPlayer(user);
            playersInRoom++;
            order.addFirst(user.getUserId());

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
                    "<select name=\"players\" class=\"selectpicker show-tick\">\n" +
                    "  <option selected=\"selected\" value=\"4\">4 Graczy</option>\n" +
                    "  <option value=\"2\">2 Graczy</option>\n" +
                    "  <option value=\"1\">1 graczy</option>\n" +
                    "</select>" +
                    "</td>" +
                    "    <td>" +
                    "<select name=\"time\" class=\"selectpicker show-tick\">\n" +
                    "  <option selected=\"selected\" value=\"0\">Nieograniczony</option>\n" +
                    "  <option value=\"1\">1 minuta</option>\n" +
                    "  <option value=\"5\">5 minut</option>\n" +
                    "  <option value=\"15\">15 minut</option>\n" +
                    "</select>" +
                    "</td>" +
                    "    <td>" +
                    "<select name=\"symbols\" class=\"selectpicker show-tick\">\n" +
                    "  <option selected=\"selected\" value=\"24\">Wszystkie symbole</option>\n" +
                    "  <option value=\"10\">10 symboli</option>\n" +
                    "  <option value=\"20\">20 symboli</option>\n" +
                    "</select>" +
                    "</td>";
        }else
        {
            resultHTMLBlock +=  "    <td>" +
                   + this.maxNumberOfPlayers +
                    "</td>" +
                    "    <td>" +
                   + this.timeForGame +
                    "</td>" +
                    "    <td>" +
                     this.numberOfSymbols +
                    "</td>";
        }
        resultHTMLBlock +=  "    <td>" +
                "        <button type=\"submit\" class=\"btn btn-primary\" id=\"roomName\" name=\"room\" value=\"" + this.roomName + "\"> Wybierz </button> " +
                "</td>" +
                "</tr>";
        return resultHTMLBlock;

    }

    public boolean isPlayer(String name){
        for(User u: this.getPlayers()){
            if(u.getLogin().equals(name)) return true;
        }
        return false;
    }

    public Player getPlayer(String name){
        for(Player p: this.getPlayers()){
            if(p.getLogin().equals(name)) return p;
        }
        return null;
    }

    /**
     * Zmiana parametrów gry
     * @param players
     * @param time
     * @param symbols
     */
    public void setGameParameters(int players, int time, int symbols)
    {
        this.numberOfSymbols=symbols;
        this.timeForGame=time;
        this.maxNumberOfPlayers=players;
        this.game=new Permutu(numberOfSymbols);
    }

    /**
     * Resetowanie pokoju gdy wszyscy gracze opuszczą pokój
     */
    public void resetRoom(){
        System.out.println("Resetowanie rozgrywki "+roomName);
        this.game=new Permutu();
        order = new LinkedList<>();
    }

    /**
     * Resetowanie pokoju gdy jedyny gracz pozostały w pokoju chce zresetować grę
     * @param p
     */
    public void resetRoom(Player p){
        System.out.println("Resetowanie rozgrywki i pozostawienie jednego gracza "+roomName);
        this.game=new Permutu();
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
