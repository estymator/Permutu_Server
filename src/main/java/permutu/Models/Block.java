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
                                          "n","o","p","q","r","s","t","u","v","w","x","y","z"," "};

    public static final String[] COLORS = {"red", "black", "green", "white"};

    public Block(int sign, int color) {
        this.sign = sign;
        this.color = color;
    }

    public Block(String s){
        int indexOf = s.indexOf('-');
        int signIndex = 0;
        int colorIndex = 0;
        String colorFromString = s.substring(0,indexOf);
        String signFromString = s.substring(indexOf + 1,s.length());
        for(int i = 0; i < SIGNS.length; i++){
            if(SIGNS[i].equals(signFromString)) signIndex = i;
        }
        for(int i = 0; i < COLORS.length; i++){
            if(COLORS[i].equals(colorFromString)) colorIndex = i;
        }
        this.sign=signIndex;
        this.color=colorIndex;
    }

    /**
     * Override method which cmopare two blocks, and decide if thers sign are equal.
     * @param that - card to which is compared.
     * @return = true if both signs are same
     */
    public boolean thisSameSign(Block that){
        return this.sign == that.sign;
    }

    public boolean equals(Block that){
        return this.getColor() == that.getColor() && this.getSign() == that.getSign();
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
        String color = getBootstrapCoolor(this.getColor());
        if(color!="text-hidden"){
            return "<button onclick=\"selected(this)\" class=\"btn block d-flex justify-content-center align-items-center rounded p-2 m-2 " + color + "\" " +
                    "id=\"" + COLORS[this.color] + "-" + SIGNS[this.sign] + "\">\n" +
                    "               " + SIGNS[this.sign].toUpperCase() +"\n" +
                    "            </button>";
        } else {
            return "<button class=\"btn block d-flex justify-content-center align-items-center rounded p-2 m-2\" style=\"opacity:0;min-height:40px\" ></button>";
        }

    }

    private String getBootstrapCoolor(int index){
        if (index==3) return "text-hidden";
        else if(index == 0) return "text-danger";
        else if(index == 1) return "text-dark";
        else return "text-success";
    }
}