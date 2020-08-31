package permutu.Models;
import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String login,password,email;
    private int userRoleID;
    private int totalGames = 0;
    private int winnGames = 0;




    public Integer getUserId() {
        return userId;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserRoleId() {
        return userRoleID;
    }

    public void setUserRoleId(int userRoleID) {
        this.userRoleID = userRoleID;
    }


    public int getTotalGames() {
        return totalGames;
    }

    public void incTotalGames() {
        this.totalGames++;
    }

    public int getWinnGames() {
        return winnGames;
    }

    public void incWinnGames() {
        this.winnGames++;
    }

    public String genereteHTMLtrForUser(){
        int winrate = 0;
        try{
            winrate = this.totalGames / this.winnGames;
        }catch(ArithmeticException e){

        }
        return "<tr>" +
                "    <th scope=\"row\">1</th>" +
                "    <td>" + this.login + "</td>" +
                "    <td>" + this.totalGames + "</td>" +
                "    <td>" + this.winnGames + "</td>" +
                "    <td>" + winrate * 100+ "%</td>" +
                "</tr>";
    }
}
