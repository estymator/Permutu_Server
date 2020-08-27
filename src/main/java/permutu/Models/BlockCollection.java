package permutu.Models;
import java.util.ArrayList;
import java.util.Random;

public class BlockCollection{

    private String label;

    protected ArrayList<Block> blocks;

    public BlockCollection(String label) {
        this.label = label;
        this.blocks = new ArrayList<>();
    }

    public void addBlock(Block block){
        blocks.add(block);
    }

    public void addBlockOrdered(Block block){
        for (int i=0; i<blocks.size(); i++){
            if (blocks.get(i).getSign()>block.getSign()) {
                blocks.add(i, block);
                return;
            }
        }
        blocks.add(block);
        return;
    }

    public int size(){
        return blocks.size();
    }

    public boolean empty(){
        return blocks.size() == 0;
    }

    public Block getBlock(int i){
        return blocks.get(i);
    }

    public String getLabel() {
        return label;
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    void swapBlocks(int firstIndex, int secondIndex){
        Block temp = blocks.get(firstIndex);
        blocks.set(firstIndex,blocks.get(secondIndex));
        blocks.set(secondIndex,temp);
    }

    public void shuffle(){
        Random generator = new Random();
        for(int i = 0; i < blocks.size(); i++){
            int j = generator.nextInt(size() -1);
            swapBlocks(i,j);
        }
    }

}