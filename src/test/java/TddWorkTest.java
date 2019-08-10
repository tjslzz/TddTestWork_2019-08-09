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
        pokers1.add(new Poker(PokerColor.H, "1"));
        pokers1.add(new Poker(PokerColor.D, "3"));
        pokers1.add(new Poker(PokerColor.S, "5"));
        pokers1.add(new Poker(PokerColor.C, "7"));
        pokers1.add(new Poker(PokerColor.H, "9"));

        pokers2.add(new Poker(PokerColor.H, "2"));
        pokers2.add(new Poker(PokerColor.D, "4"));
        pokers2.add(new Poker(PokerColor.S, "6"));
        pokers2.add(new Poker(PokerColor.C, "8"));
        pokers2.add(new Poker(PokerColor.H, "T"));

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
        assertEquals("1平局", pokers1.get(0).compareTo(pokers1.get(0)).toString());
    }

    @Test
    public void should_return_bigger_one_when_call_compareTo_given_word_and_number() {
        assertEquals("TD", new Poker(PokerColor.D, "2").compareTo(new Poker(PokerColor.D, "T")).toString());
        assertEquals("JD", new Poker(PokerColor.D, "T").compareTo(new Poker(PokerColor.D, "J")).toString());
        assertEquals("QD", new Poker(PokerColor.D, "J").compareTo(new Poker(PokerColor.D, "Q")).toString());
        assertEquals("KD", new Poker(PokerColor.D, "Q").compareTo(new Poker(PokerColor.D, "K")).toString());
        assertEquals("AD", new Poker(PokerColor.D, "K").compareTo(new Poker(PokerColor.D, "A")).toString());
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
    public void should_return_lev2_when_call_getMyLevel_given_pair() {
        user1.setPokers(pair());
        assertEquals(2, user1.getMyLevel());
    }

    @Test
    public void should_return_winner_tomcat_when_call_judges_given_two_levels_user() {
        user1.setPokers(highCard());
        user2.setPokers(pair());
        assertEquals("Tomcat", tddWork.judges(user1, user2).getUserName());
    }

    @Test
    public void should_return_lev3_when_call_getMyLevel_given_two_pairs() {
        user1.setPokers(twoPair());
        assertEquals(3, user1.getMyLevel());
    }

    @Test
    public void should_return_lev4_when_call_getMyLevel_given_three_of_a_kind() {
        user1.setPokers(threeKind());
        assertEquals(4, user1.getMyLevel());
    }

    @Test
    public void should_return_lev5_when_call_getMyLevel_given_flush() {
        user1.setPokers(flush());
        assertEquals(5, user1.getMyLevel());
    }

    @Test
    public void should_return_lev6_when_call_getMyLevel_given_full_house() {
        user1.setPokers(fullHouse());
        assertEquals(6, user1.getMyLevel());
    }

    private List<Poker> highCard() {
        List<Poker> list = new ArrayList<>();
        list.add(new Poker(PokerColor.C, "2"));
        list.add(new Poker(PokerColor.D, "4"));
        list.add(new Poker(PokerColor.S, "6"));
        list.add(new Poker(PokerColor.H, "8"));
        list.add(new Poker(PokerColor.C, "T"));
        return list;
    }

    private List<Poker> pair() {
        List<Poker> list = new ArrayList<>();
        list.add(new Poker(PokerColor.C, "2"));
        list.add(new Poker(PokerColor.D, "2"));
        list.add(new Poker(PokerColor.H, "6"));
        list.add(new Poker(PokerColor.S, "8"));
        list.add(new Poker(PokerColor.C, "T"));
        return list;
    }

    private List<Poker> twoPair() {
        List<Poker> list = new ArrayList<>();
        list.add(new Poker(PokerColor.C, "2"));
        list.add(new Poker(PokerColor.D, "2"));
        list.add(new Poker(PokerColor.H, "6"));
        list.add(new Poker(PokerColor.S, "6"));
        list.add(new Poker(PokerColor.C, "T"));
        return list;
    }

    private List<Poker> threeKind() {
        List<Poker> list = new ArrayList<>();
        list.add(new Poker(PokerColor.C, "2"));
        list.add(new Poker(PokerColor.D, "2"));
        list.add(new Poker(PokerColor.H, "2"));
        list.add(new Poker(PokerColor.S, "6"));
        list.add(new Poker(PokerColor.C, "T"));
        return list;
    }

    private List<Poker> flush() {
        List<Poker> list = new ArrayList<>();
        list.add(new Poker(PokerColor.C, "2"));
        list.add(new Poker(PokerColor.C, "4"));
        list.add(new Poker(PokerColor.C, "6"));
        list.add(new Poker(PokerColor.C, "8"));
        list.add(new Poker(PokerColor.C, "T"));
        return list;
    }

    private List<Poker> fullHouse() {
        List<Poker> list = new ArrayList<>();
        list.add(new Poker(PokerColor.C, "2"));
        list.add(new Poker(PokerColor.D, "2"));
        list.add(new Poker(PokerColor.H, "2"));
        list.add(new Poker(PokerColor.S, "8"));
        list.add(new Poker(PokerColor.C, "8"));
        return list;
    }
}