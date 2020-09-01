package permutu.Models;


import java.io.Serializable;

public class SettingsModel implements Serializable {


    private String inputLogin;
    private String inputPassword4;
    private String inputEmail4;
    private String inputPassword24;
    private String currentLogin;

    public SettingsModel() {
    }

    public SettingsModel(String inputLogin, String inputPassword4, String inputEmail4, String inputPassword24, String currentLogin) {
        this.inputLogin = inputLogin;
        this.inputPassword4 = inputPassword4;
        this.inputEmail4 = inputEmail4;
        this.inputPassword24 = inputPassword24;
        this.currentLogin = currentLogin;
    }

    public String getInputLogin() {
        return inputLogin;
    }

    public void setInputLogin(String inputLogin) {
        this.inputLogin = inputLogin;
    }

    public String getInputPassword4() {
        return inputPassword4;
    }

    public void setInputPassword4(String inputPassword4) {
        this.inputPassword4 = inputPassword4;
    }

    public String getInputEmail4() {
        return inputEmail4;
    }

    public void setInputEmail4(String inputEmail4) {
        this.inputEmail4 = inputEmail4;
    }

    public String getInputPassword24() {
        return inputPassword24;
    }

    public void setInputPassword24(String inputPassword24) {
        this.inputPassword24 = inputPassword24;
    }

    public String getCurrentLogin() {
        return currentLogin;
    }

    public void setCurrentLogin(String currentLogin) {
        this.currentLogin = currentLogin;
    }
}
