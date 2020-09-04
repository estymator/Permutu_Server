package permutu.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PileTest {



    @Test
    public void test_correctPileSize_negativeParameter_returnFalse() throws Exception{
        //given
        Pile pile = new Pile("green");
        int size = -23;
        //when
        assertFalse(pile.correctPileSize(size));
    }

    @Test
    public void test_correctPileSize_ParameterGreaterThen26_returnFalse() throws Exception{
        //given
        Pile pile = new Pile("green");
        int size = 30;
        //when
        assertFalse(pile.correctPileSize(size));
    }

    @Test
    public void test_correctPileSize_PropertyParameter_returnTrue() throws Exception{
        //given
        Pile pile = new Pile("green");
        int size = 15;
        //when
        assertTrue(pile.correctPileSize(size));
    }
}