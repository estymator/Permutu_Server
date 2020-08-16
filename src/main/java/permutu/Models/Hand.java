package permutu.Models;

public class Hand extends BlockCollection {

    public Hand(String label) {
        super(label);

    }


    public String display() {
            String out = "";
            out = (getLabel() + ": ");
            for (int i = 0; i < size(); ++i) {
                out = out + (i + " - |" + getBlock(i) + "| ");
            }
            return out;
    }



}
