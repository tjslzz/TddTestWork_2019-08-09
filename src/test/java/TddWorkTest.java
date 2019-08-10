import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TddWorkTest {

    @Test
    public void should_return_3D_when_call_compareTo_given_2H_and_3D(){
        Poker poker1 = new Poker(PokerColor.H,"2");
        Poker poker2 = new Poker(PokerColor.D,"3");
        assertEquals("3D",poker1.compareTo(poker2));
    }

    @Test
    public void should_return_equal_when_call_compareTo_given_2H_and_2H(){
        Poker poker1 = new Poker(PokerColor.C,"2");
        Poker poker2 = new Poker(PokerColor.D,"2");
        assertEquals("平局",poker1.compareTo(poker2));
    }

    @Test
    public void should_return_bigger_one_when_call_compareTo_given_word_and_number(){
        Poker poker1 = new Poker(PokerColor.C,"2");
        Poker poker2 = new Poker(PokerColor.D,"T");
    }
}