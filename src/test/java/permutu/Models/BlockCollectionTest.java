package permutu.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockCollectionTest {

    @Test
    void test_swapBlocks() {
        //given
        BlockCollection blockCollection = new BlockCollection("test");
        Block blockOne = new Block(5,2);
        Block blockTwo = new Block(5,2);
        blockCollection.addBlock(blockOne);
        blockCollection.addBlock(blockTwo);
        //when
        assertEquals(blockCollection.getBlock(1),blockTwo);
        blockCollection.swapBlocks(0,1);
        assertEquals(blockCollection.getBlock(1),blockOne);
    }

    @Test
    void test_isThisSign_returnTrue() {
        BlockCollection blockCollection = new BlockCollection("test");
        Block blockOne = new Block(5,2);
        Block blockTwo = new Block(2,2);
        Block blockThree = new Block(5,1);
        blockCollection.addBlock(blockOne);
        blockCollection.addBlock(blockTwo);
        blockCollection.addBlock(blockThree);

        assertTrue(blockCollection.isThisSign(blockThree));
    }

    @Test
    void test_isThisSign_returnFalse() {
        BlockCollection blockCollection = new BlockCollection("test");
        Block blockOne = new Block(5,2);
        Block blockTwo = new Block(2,2);
        Block blockThree = new Block(5,1);
        Block blockFour= new Block(6,1);

        blockCollection.addBlock(blockOne);
        blockCollection.addBlock(blockTwo);
        blockCollection.addBlock(blockThree);


        assertFalse(blockCollection.isThisSign(blockFour));
    }
}