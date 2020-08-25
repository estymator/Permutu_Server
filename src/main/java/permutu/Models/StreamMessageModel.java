package permutu.Models;

public class StreamMessageModel {

    private String playerLogin;

    private String[] selectedBlocks;

    public StreamMessageModel(String playerLogin, String[] selectedBlocks) {
        this.selectedBlocks = selectedBlocks;
        this.playerLogin = playerLogin;
    }


    public String getPlayerLogin() {
        return playerLogin;
    }


    public String[] getselectedBlocks() {
        return selectedBlocks;
    }

    public void setselectedBlocks(String[] selectedBlocks) {
        this.selectedBlocks = selectedBlocks;
    }
}
