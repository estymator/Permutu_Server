package permutu.Models;

import java.sql.Timestamp;
import java.util.ArrayList;

public class HistoryDTO {
    private Timestamp timestamp;
    private String winner;
    private Integer gameid;
    private ArrayList<String> userLogins;

    public HistoryDTO() {
        this.userLogins = new ArrayList<String>();
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public Integer getGameid() {
        return gameid;
    }

    public void setGameid(Integer gameid) {
        this.gameid = gameid;
    }

    public ArrayList<String> getUserLogins() {
        return userLogins;
    }

    public String userLoginsToOneString() {
        StringBuilder sb = new StringBuilder();
        for(String s: userLogins){
            sb.append(s);
            sb.append(", ");
        }
        return sb.toString();
    }

    public void setUserLogins(ArrayList<String> userLogins) {
        this.userLogins = userLogins;
    }



    public String genereteHTML(){
        return "<tr>" +
                "    <th scope=\"row\">1</th>" +
                "    <td>" + this.timestamp + "</td>" +
                "    <td>" + this.userLoginsToOneString() + "</td>" +
                "    <td>" + this.winner + "</td>" +
                "</tr>";
    }
}
