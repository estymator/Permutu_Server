package permutu.Models;
import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String login,password,email;
    private int userRoleID, userRoleUrlID;

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

    public void setUserRoleId(int userRoleId) {
        this.userRoleID = userRoleId;
    }

    public int getUserRoleUrlID() {
        return userRoleUrlID;
    }

    public void setUserRoleUrlID(int userRoleUrlID) {
        this.userRoleUrlID = userRoleUrlID;
    }
}
