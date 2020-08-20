package permutu.Models;

public class Permutu {

    private Players players;
    /**
     * Store Pile of Cards
     */
    private Hand mainPile;

    private Pile redPile;

    private Pile blackPile;

    private Pile greenPile;

    public Permutu(){
        try {
            this.redPile = new Pile("red");
            redPile.shuffle();

            this.blackPile = new Pile("black");
            blackPile.shuffle();

            this.greenPile = new Pile("green");
            greenPile.shuffle();

            players = new Players("RoomName");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }

    public Hand getMainPile() {
        return mainPile;
    }

    public void setMainPile(Hand mainPile) {
        this.mainPile = mainPile;
    }

    public Pile getRedPile() {
        return redPile;
    }

    public void setRedPile(Pile redPile) {
        this.redPile = redPile;
    }

    public Pile getBlackPile() {
        return blackPile;
    }

    public void setBlackPile(Pile blackPile) {
        this.blackPile = blackPile;
    }

    public Pile getGreenPile() {
        return greenPile;
    }

    public void setGreenPile(Pile greenPile) {
        this.greenPile = greenPile;
    }
}
