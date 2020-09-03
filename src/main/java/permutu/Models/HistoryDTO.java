package permutu.Models;

import java.sql.Timestamp;
import java.util.ArrayList;

public class HistoryDTO {
    private Timestamp timestamp;
    private String winner;
    private Integer gameid;
    private Integer mode;
    private Integer symbols;
    private Integer time;
    private ArrayList<String> userLogins;

    public HistoryDTO(Timestamp timestamp, String winner, Integer gameid, Integer mode, Integer symbols, Integer time) {
        this.timestamp = timestamp;
        this.winner = winner;
        this.gameid = gameid;
        this.mode = mode;
        this.symbols = symbols;
        this.time = time;
        this.userLogins = new ArrayList<String>();
    }

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

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public Integer getSymbols() {
        return symbols;
    }

    public void setSymbols(Integer symbols) {
        this.symbols = symbols;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
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

    private String returnModeString(){
        if(mode == 1){
            return "Kto pierwszy ten lepszy";
        }
        return "Losowa kolejność";
    }

    private String returnTimeString(){
        if(time == 0){
            return "Nie na czas";
        }
        else if(time == 1){
            return "1min";
        }
        else if(time == 5){
            return "5min";
        }
        return "15min";
    }

    private String returnNumberOfSymbolsString(){
        if(symbols == 24) return "Wszystkie symbole";
        return ""+symbols;
    }


    public String genereteHTML(int rowNumber){
        return "<tr>" +
                "    <th scope=\"row\">" + rowNumber +"</th>" +
                "    <td>" + this.timestamp + "</td>" +
                "    <td>" + this.userLoginsToOneString() + "</td>" +
                "    <td>" + this.returnTimeString() + "</td>" +
                "    <td>" + this.returnNumberOfSymbolsString() + "</td>" +
                "    <td>" + this.returnModeString() + "</td>" +
                "    <td>" + this.winner + "</td>" +
                "</tr>";
    }
}
