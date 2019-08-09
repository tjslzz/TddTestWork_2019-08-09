import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TddWorkTest {

    private Poker poker1;
    private Poker poker2;
    private TddWork tddWork;

    @Before
    public void setUp(){
        poker1 = new Poker("H","2");
        poker2 = new Poker("D","3");
        tddWork = new TddWork();
    }

    @Test
    public void should_return_3D_when_call_judges_given_2H_and_3D(){
        assertEquals("3D",tddWork.judges(poker1,poker2));
    }

    @Test
    public void should_return_equal_when_call_judges_given_2H_and_2H(){
        poker2.setNumber("2");
        assertEquals("平局",tddWork.judges(poker1,poker2));
    }
}