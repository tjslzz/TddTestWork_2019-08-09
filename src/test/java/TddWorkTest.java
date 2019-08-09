import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TddWorkTest {

    private String user1;
    private String user2;
    private TddWork tddWork;

    @Before
    public void setUp(){
        user1 = "2H";
        user2 = "3D";
        tddWork = new TddWork();
    }

    @Test
    public void should_return_3D_when_call_judges_given_2H_and_3D(){
        assertEquals("3D",tddWork.judges(user1,user2));
    }
}