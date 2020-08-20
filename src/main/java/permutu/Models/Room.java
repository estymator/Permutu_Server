package permutu.Models;

public class Room {

    private String  roomName;

    private Integer playersInRoom;

    private final Integer MAX_NUMBERS_OF_PLAYERS = 4;

    private Permutu game;

    public Room(String roomName, Permutu game) {
        this.roomName = roomName;
        this.game = game;
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
}
