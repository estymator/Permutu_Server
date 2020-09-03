package permutu.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutuTest {

    private final static Permutu permutu = new Permutu(24);

    @Test
    public void test_checkWhetherIsFromThisSameColumn_isNotInThisSameColumn_returnFalse(){
        //given

        BlockCollection blockCollection = new BlockCollection("blocks");

        blockCollection.addBlock(permutu.getBlackPile().blocks.get(2));
        blockCollection.addBlock(permutu.getGreenPile().blocks.get(6));
        blockCollection.addBlock(permutu.getRedPile().blocks.get(10));

        assertFalse(permutu.checkWhetherIsFromThisSameColumn(blockCollection));

    }

    @Test
    public void test_checkWhetherIsFromThisSameColumn_isInThisSameColumn_returnTrue(){
        //given
        BlockCollection blockCollection = new BlockCollection("blocks");

        blockCollection.addBlock(permutu.getBlackPile().blocks.get(7));
        blockCollection.addBlock(permutu.getGreenPile().blocks.get(7));
        blockCollection.addBlock(permutu.getRedPile().blocks.get(7));

        //when
        assertTrue(permutu.checkWhetherIsFromThisSameColumn(blockCollection));

    }

    @Test
    public void test_isInFullColumn_is_returnTrue(){
        //given
        Block block  = permutu.getBlackPile().blocks.get(7);

        //when
        assertTrue(permutu.isInFullColumn(block));
    }

    @Test
    public void test_removeFromBoard_blockWasRemoved_InThisPlaceIsWhiteBlock(){
        //given
        Block block = permutu.getBlackPile().blocks.get(7);

        //When
        permutu.removeFromBoard(block);
        assertEquals(permutu.getBlackPile().blocks.get(7).getColor(),3);
    }

    @Test
    public void test_isInFullColumn_isNot_returnFalse(){
        //given
        Block block  = permutu.getBlackPile().blocks.get(7);
        permutu.removeFromBoard(block);

        Block block2 = permutu.getGreenPile().blocks.get(7);
        //when
        assertFalse(permutu.isInFullColumn(block2));
    }

    @Test
    public void test_isDone_isNot_returnFalse(){
        assertFalse(permutu.isDone());
    }

    @Test
    public void test_isSaved_isNot_returnFalse(){
        assertFalse(permutu.isSaved());
    }

    @Test
    public void test_isSaved_is_returnTrue(){
        //given
        permutu.setSaved(true);
        //when
        assertTrue(permutu.isSaved());
    }







}