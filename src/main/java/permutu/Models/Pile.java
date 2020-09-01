package permutu.Models;

public class Pile extends BlockCollection {

    public Pile(String label) throws Exception {
        super(label);
        if(label.equals("red")) {
            for (int sign = 0; sign < 26; ++sign) {
                blocks.add(new Block(sign, 0));
            }
        }
        else if(label.equals("black")){
            for (int sign = 0; sign < 26; ++sign) {
                blocks.add(new Block(sign, 1));
            }
        }
        else if(label.equals("green")){
            for (int sign = 0; sign < 26; ++sign) {
                blocks.add(new Block(sign, 2));
            }
        }
        else{
            throw new Exception("Bad label");
        }
    }



    public Pile(String label, int pileSize) throws Exception {
        super(label);
        if(correctPileSize(pileSize)){
            if(label.equals("red")) {
                for (int sign = 0; sign < pileSize; ++sign) {
                    blocks.add(new Block(sign, 0));
                }
            }
            else if(label.equals("black")){
                for (int sign = 0; sign < pileSize; ++sign) {
                    blocks.add(new Block(sign, 1));
                }
            }
            else if(label.equals("green")){
                for (int sign = 0; sign < pileSize; ++sign) {
                    blocks.add(new Block(sign, 2));
                }
            }
            else{
                throw new Exception("Bad label");
            }
        }
        else {
            throw  new Exception("Bad Pile Size");
        }
    }

    public boolean correctPileSize(int pileSize){
        return pileSize > 0 && pileSize < 26;
    }

}
