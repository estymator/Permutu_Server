package permutu.Models;

import java.util.ArrayList;

public class Room {

    private String  roomName;

    private Integer playersInRoom = 0;

    private final Integer MAX_NUMBERS_OF_PLAYERS = 4;

    private Permutu game;
    private Players players;

    public ArrayList<Player> getPlayers() {
        return players.getPlayers();
    }

    public void setPlayers(Players players) {
        this.players = players;
    }

    public Room(String roomName, Permutu game) {
        this.roomName = roomName;
        this.game = game;
        this.players = new Players();
    }



    public void addPlayer(User user){
        if(players.size()<MAX_NUMBERS_OF_PLAYERS)
        {
            players.addPlayer(user);
            playersInRoom++;
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

                playersInRoom--;
                if(players.size()==0)
                {

                    resetRoom();
                }
                return true;
            }
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
        return "<tr>" +
                "    <th scope=\"row\">1</th>" +
                "    <td>" + this.roomName + "</td>" +
                "    <td>" + this.playersInRoom + "</td>" +
                "    <td>" +
                "        <input type=\"checkbox\" class=\"form-check-input\" id=\"roomName\" name=\"room\" value=\"" + this.roomName + "\">" +
                "        <label for=\"roomId\">Wybierz</label>" +
                    "</td>" +
                "</tr>";
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

    public void resetRoom(){
        System.out.println("Resetowanie rozgrywki "+roomName);
        this.game=new Permutu();
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

}
