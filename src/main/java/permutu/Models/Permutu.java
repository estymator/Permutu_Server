package permutu.Models;



import java.util.ArrayList;

public class Permutu {

    public ArrayList<String> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }

    private ArrayList<String>history;

    private Players players;

    private Hand mainPile;

    private Pile redPile;

    private Pile blackPile;

    private Pile greenPile;

    private boolean saved = false;

    public Permutu() {
        try {
            this.redPile = new Pile("red");
            redPile.shuffle();

            this.blackPile = new Pile("black");
            blackPile.shuffle();

            this.greenPile = new Pile("green");
            greenPile.shuffle();

            players = new Players("RoomName");

            history = new ArrayList<String>();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Constructor for custom symbols number
     * @param size
     */
    public Permutu(int size) {
        try {
            this.redPile = new Pile("red",size);
            redPile.shuffle();

            this.blackPile = new Pile("black",size);
            blackPile.shuffle();

            this.greenPile = new Pile("green",size);
            greenPile.shuffle();

            players = new Players("RoomName");

            history = new ArrayList<String>();

        } catch (Exception e) {
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

    public void remove(Block b) {
        if (b.getColor() == 0) {
            for (Block bb : this.redPile.getBlocks()) {
                if (bb.equals(b)) {
                    this.redPile.getBlocks().remove(bb);
                    return;
                }
            }
        } else if (b.getColor() == 2) {
            for (Block bb : this.greenPile.getBlocks()) {
                if (bb.equals(b)) {
                    this.greenPile.getBlocks().remove(bb);
                    return;
                }
            }
        } else {
            for (Block bb : this.blackPile.getBlocks()) {
                if (bb.equals(b)) {
                    this.blackPile.getBlocks().remove(bb);
                    return;
                }
            }
        }
    }

    public void removeFromBoard(Block b) {
        if (b.getColor() == 0) {
            ArrayList<Block> blockList = this.redPile.getBlocks();
            for (int ii = 0; ii < blockList.size(); ii++) {
                if (blockList.get(ii).equals(b)) {
                    blockList.set(ii, new Block("white- "));
                    return;
                }
            }
        } else if (b.getColor() == 2) {
            ArrayList<Block> blockList = this.greenPile.getBlocks();
            for (int ii = 0; ii < blockList.size(); ii++) {
                if (blockList.get(ii).equals(b)) {
                    blockList.set(ii, new Block("white- "));
                    return;
                }
            }
        } else {
            ArrayList<Block> blockList = this.blackPile.getBlocks();
            for (int ii = 0; ii < blockList.size(); ii++) {
                if (blockList.get(ii).equals(b)) {
                    blockList.set(ii, new Block("white- "));
                    return;
                }
            }
        }
    }

    public boolean checkWhetherIsFromThisSameColumn(BlockCollection blocks) {
        int indexFromReds = -2;
        int indexFromGreens = -4;
        int indexFromBlacks = -3;

        for (Block b : blocks.getBlocks()) {
            if (this.redPile.indexOf(b) >= 0) {
                indexFromReds = this.redPile.indexOf(b);
            } else if (this.blackPile.indexOf(b) >= 0) {
                indexFromBlacks = this.blackPile.indexOf(b);
            } else if (this.greenPile.indexOf(b) >= 0) {
                indexFromGreens = this.greenPile.indexOf(b);
            }
        }

        if(blocks.size() == 2){
            if(indexFromBlacks == indexFromGreens || indexFromBlacks == indexFromReds || indexFromGreens == indexFromReds){
                return true;
            }
        }
        if(indexFromBlacks == indexFromGreens && indexFromBlacks == indexFromReds && indexFromGreens == indexFromReds) {
            return true;
        }
        return false;
    }

    public boolean isInFullColumn(Block b) {
        int indexFromReds = this.redPile.indexOf(b);
        int indexFromGreens = this.greenPile.indexOf(b);
        int indexFromBlacks = this.blackPile.indexOf(b);
        if (indexFromBlacks != -1) {
            if (this.redPile.getBlock(indexFromBlacks).getColor() != 3 && this.greenPile.getBlock(indexFromBlacks).getColor() != 3)
                return true;
        } else if (indexFromReds != -1) {
            if (this.greenPile.getBlock(indexFromReds).getColor() != 3 && this.blackPile.getBlock(indexFromReds).getColor() != 3)
                return true;
        } else if (indexFromGreens != -1) {
            if (this.redPile.getBlock(indexFromGreens).getColor() != 3 && this.blackPile.getBlock(indexFromGreens).getColor() != 3)
                return true;
        }
        return false;
    }

    public boolean haventAnyPlayer(ArrayList<Player> players, Block b, Player currentPlayer) {
        for (Player p : players) {
            if (p.equals(currentPlayer)) continue;
            else {
                for (Block bb : p.getBlocksInHand().getBlocks()) {
                    if (bb.getSign() == b.getSign()) return false;
                }
            }
        }
        return true;
    }

    public boolean playerHaveAllSignFromColumn(Player p, BlockCollection selectedBlocks) {
        for (Block b : selectedBlocks.getBlocks()) {
            if(!p.getBlocksInHand().isThisSign(b)) return false;
        }
        return  true;
    }

    public boolean playerDontHaveOneSignFromThisColumn(Player p, BlockCollection selectedBlocks){
        int counter = 0;
        for (Block b : selectedBlocks.getBlocks()) {
            if(!p.getBlocksInHand().isThisSign(b)) counter++;
        }
        return  counter == 1;
    }

    public boolean isDone(){
        for(Block b: redPile.blocks){
            if(b.getColor() != 3) return false;
        }
        for(Block b: greenPile.blocks){
            if(b.getColor() != 3) return false;
        }
        for(Block b: blackPile.blocks){
            if(b.getColor() != 3) return false;
        }
        return true;
    }

    public boolean anyPLayerDontHaveAnySignFromThisSet(ArrayList<Player> players, BlockCollection selectedBlocks, Player p){
        for(Block b: selectedBlocks.getBlocks()){
                return haventAnyPlayer(players,b,p);
        }
        return false;
    }


    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }
}


