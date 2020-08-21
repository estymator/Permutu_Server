package permutu.Models;

public class StreamMessageModel {

    private String playerLogin;

    private String[] move;

    public StreamMessageModel(String playerLogin, String[] move) {
        this.move = move;
        this.playerLogin = playerLogin;
    }


    public String getPlayerLogin() {
        return playerLogin;
    }


    public String[] getMove() {
        return move;
    }

    public void setMove(String[] move) {
        this.move = move;
    }
}
