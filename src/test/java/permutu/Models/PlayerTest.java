package permutu.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void test_countPoints_onePoint() {
        Player player = new Player();

        Block blockOne = new Block(5,2);
        Block blockTwo = new Block(2,2);
        Block blockThree = new Block(5,1);
        Block blockFour= new Block(6,1);

        player.getBlocksInHand().addBlock(blockOne);
        player.getBlocksInHand().addBlock(blockTwo);
        player.getBlocksInHand().addBlock(blockThree);

        player.countPoints();
        int expectedPoints = 1;

        assertEquals(player.getPoints(),expectedPoints);
    }
    @Test
    void test_countPoints_ZeroPoints() {
        Player player = new Player();

        Block blockOne = new Block(7,2);
        Block blockTwo = new Block(2,2);
        Block blockThree = new Block(5,1);
        Block blockFour= new Block(6,1);

        player.getBlocksInHand().addBlock(blockOne);
        player.getBlocksInHand().addBlock(blockTwo);
        player.getBlocksInHand().addBlock(blockThree);

        player.countPoints();
        int expectedPoints = 0;

        assertEquals(player.getPoints(),expectedPoints);
    }

    @Test
    void test_countPoints_ThreePoints() {
        Player player = new Player();

        Block blockOne = new Block(5,3);
        Block blockTwo = new Block(5,2);
        Block blockThree = new Block(5,1);
        Block blockFour= new Block(6,1);

        player.getBlocksInHand().addBlock(blockOne);
        player.getBlocksInHand().addBlock(blockTwo);
        player.getBlocksInHand().addBlock(blockThree);

        player.countPoints();
        int expectedPoints = 3;

        assertEquals(player.getPoints(),expectedPoints);
    }

}