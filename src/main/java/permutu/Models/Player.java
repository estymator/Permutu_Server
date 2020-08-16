package permutu.Models;

public class Player extends User {

    private Hand pileInHand;

    Player(){
        super();
        pileInHand = new Hand(this.getLogin() + " Pile");
    }

}
