import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TddWorkTest {

    private TddWork tddWork;
    private List<Poker> pokers1 = new ArrayList<>();
    private List<Poker> pokers2 = new ArrayList<>();
    private User user1;
    private User user2;

    @Before
    public void setUp() {
        pokers1.add(new Poker(PokerColor.H, "2"));
        pokers1.add(new Poker(PokerColor.D, "3"));
        pokers1.add(new Poker(PokerColor.C, "2"));
        pokers1.add(new Poker(PokerColor.D, "2"));
        pokers1.add(new Poker(PokerColor.C, "2"));

        pokers2.add(new Poker(PokerColor.D, "T"));
        pokers2.add(new Poker(PokerColor.D, "J"));
        pokers2.add(new Poker(PokerColor.D, "Q"));
        pokers2.add(new Poker(PokerColor.D, "K"));
        pokers2.add(new Poker(PokerColor.D, "A"));

        user1 = new User("JerryLi", pokers1);
        user2 = new User("Tomcat", pokers2);
        tddWork = new TddWork();
    }

    @Test
    public void should_return_3D_when_call_compareTo_given_2H_and_3D() {
        assertEquals("3D", pokers1.get(0).compareTo(pokers1.get(1)).toString());
    }

    @Test
    public void should_return_equal_when_call_compareTo_given_2H_and_2H() {
        assertEquals("2平局", pokers1.get(2).compareTo(pokers1.get(3)).toString());
    }

    @Test
    public void should_return_bigger_one_when_call_compareTo_given_word_and_number() {
        assertEquals("TD", pokers1.get(4).compareTo(pokers2.get(0)).toString());
        assertEquals("JD", pokers2.get(0).compareTo(pokers2.get(1)).toString());
        assertEquals("QD", pokers2.get(1).compareTo(pokers2.get(2)).toString());
        assertEquals("KD", pokers2.get(2).compareTo(pokers2.get(3)).toString());
        assertEquals("AD", pokers2.get(3).compareTo(pokers2.get(4)).toString());
    }

    @Test
    public void should_return_winner_user_when_call_judges_given_two_users_with_each_five_pokers() {
        assertEquals("Tomcat", tddWork.judges(user1, user2).getUserName());
    }

    @Test
    public void should_return_lev1_when_call_getMyLevel_given_high_card() {
        user1.setPokers(highCard());
        assertEquals(1, user1.getMyLevel());
    }

    @Test
    public void should_return_lev1_when_call_getMyLevel_given_pair() {
        user1.setPokers(pair());
        assertEquals(2, user1.getMyLevel());
    }

    @Test
    public void should_return_winner_tomcat_when_call_judges_given_two_levels_user(){
        user1.setPokers(highCard());
        user2.setPokers(pair());
        assertEquals("tomcat",tddWork.judges(user1,user2).getUserName());
    }

    private List<Poker> highCard() {
        List<Poker> list = new ArrayList<>();
        list.add(new Poker(PokerColor.C, "2"));
        list.add(new Poker(PokerColor.C, "4"));
        list.add(new Poker(PokerColor.C, "6"));
        list.add(new Poker(PokerColor.C, "8"));
        list.add(new Poker(PokerColor.C, "10"));
        return list;
    }

    private List<Poker> pair() {
        List<Poker> list = new ArrayList<>();
        list.add(new Poker(PokerColor.C, "2"));
        list.add(new Poker(PokerColor.C, "2"));
        list.add(new Poker(PokerColor.C, "6"));
        list.add(new Poker(PokerColor.C, "8"));
        list.add(new Poker(PokerColor.C, "10"));
        return list;
    }
}