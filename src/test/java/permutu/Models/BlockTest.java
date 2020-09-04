package permutu.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockTest {

    @Test
    void thisSameSign() {
        Block blockOne = new Block(5,2);
        Block blockTwo = new Block(5,1);

        assertTrue(blockOne.thisSameSign(blockTwo));
    }

    @Test
    void testEquals() {
        Block blockOne = new Block(5,2);
        Block blockTwo = new Block(5,2);

        assertTrue(blockOne.thisSameSign(blockTwo));
    }

    @Test
    void thisSameSign_returnFalse() {
        Block blockOne = new Block(8,2);
        Block blockTwo = new Block(5,1);

        assertFalse(blockOne.thisSameSign(blockTwo));
    }

    @Test
    void testEquals_returnFalse() {
        Block blockOne = new Block(7,2);
        Block blockTwo = new Block(5,2);

        assertFalse(blockOne.thisSameSign(blockTwo));
    }
}