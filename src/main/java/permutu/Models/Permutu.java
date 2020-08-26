package permutu.Models;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

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

    public void remove(Block b){
        if(b.getColor() == 0){
            for(Block bb : this.redPile.getBlocks()){
                if(bb.equals(b)) {
                    this.redPile.getBlocks().remove(bb);
                    return;
                }
            }
        }
        else if(b.getColor() == 2){
            for(Block bb : this.greenPile.getBlocks()){
                if(bb.equals(b)) {
                    this.greenPile.getBlocks().remove(bb);
                    return;
                }
            }
        }
        else{
            for(Block bb : this.blackPile.getBlocks()){
                if(bb.equals(b)) {
                    this.blackPile.getBlocks().remove(bb);
                    return;
                }
            }
        }
    }

    public void removeFromBoard(Block b){
        if(b.getColor() == 0){
            ArrayList<Block> blockList = this.redPile.getBlocks();
            for (int ii=0; ii<blockList.size(); ii++){
                if(blockList.get(ii).equals(b)) {
                    blockList.set(ii, new Block("white- "));
                    return;
                }
            }
        }
        else if(b.getColor() == 2){
            ArrayList<Block> blockList = this.greenPile.getBlocks();
            for (int ii=0; ii<blockList.size(); ii++){
                if(blockList.get(ii).equals(b)) {
                    blockList.set(ii, new Block("white- "));
                    return;
                }
            }
        }
        else{
            ArrayList<Block> blockList = this.blackPile.getBlocks();
            for (int ii=0; ii<blockList.size(); ii++){
                if(blockList.get(ii).equals(b)) {
                    blockList.set(ii, new Block("white- "));
                    return;
                }
            }
        }
    }
}
