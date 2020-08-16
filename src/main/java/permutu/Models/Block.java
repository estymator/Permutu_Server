package permutu.Models;

/**
 *
 * @author Tomasz Miś
 *
 *
 * Block represent all single block.
 */

public class Block{
    private final int sign;

    private final int color;

    public static final String[] SIGNS = {"a","b","c","d","e","f","g","h","i","j","k","l","m",
                                          "n","o","p","q","r","s","t","u","v","w","x","y","z"};

    public static final String[] COLORS = {"red", "black", "green"};

    public Block(int sign, int color) {
        this.sign = sign;
        this.color = color;
    }

    /**
     * Override method which cmopare two blocks, and decide if thers sign are equal.
     * @param that - card to which is compared.
     * @return = true if both signs are same
     */
    public boolean equals(Block that){
        return this.sign == that.sign;
    }

    /**
     * Override method which return String
     */
    public String toString(){
        return SIGNS[this.sign] + COLORS[this.color];
    }

    public int getSign() {
        return sign;
    }

    public int getColor() {
        return color;
    }

    public String genereteHTMLBlock(){
        return "<button onclick=\"selected(this)\" class=\"btn block d-flex justify-content-center align-items-center rounded p-2 m-2\" " +
                "id=\"" + COLORS[this.color] + "-" + SIGNS[this.sign] + "\">\n" +
                "               " + SIGNS[this.sign] +"\n" +
                "            </button>";
    }
}