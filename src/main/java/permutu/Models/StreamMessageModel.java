package permutu.Models;

public class StreamMessageModel {

    private Integer gameId;

    private Integer playerId;

    private String[] move;

    public StreamMessageModel(Integer gameId, Integer playerId, String[] move) {
        this.gameId = gameId;
        this.move = move;
        this.playerId = playerId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public Integer getPlayerId() {
        return playerId;
    }


    public String[] getMove() {
        return move;
    }

    public void setMove(String[] move) {
        this.move = move;
    }
}
