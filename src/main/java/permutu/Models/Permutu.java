package permutu.Models;

public class Permutu {

    private Players players;
    /**
     * Store Pile of Cards
     */
    private Hand mainPile;

    public Permutu(){
        try {
            Pile redPile = new Pile("red");
            redPile.shuffle();

            Pile blackPile = new Pile("black");
            blackPile.shuffle();

            Pile greenPile = new Pile("green");
            greenPile.shuffle();

            players = new Players("RoomName");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
