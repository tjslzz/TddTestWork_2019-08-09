import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private String userName;
    private List<Poker> pokers;
    private static final Long COUNT_POKERS = 5L;
    private static final int HIGH_CARD_LEVEL = 1;
    private static final int PAIR_LEVEL = 2;

    public User(String userName, List<Poker> pokers) {
        this.userName = userName;
        this.pokers = pokers;
    }

    public void setPokers(List<Poker> pokers) {
        this.pokers = pokers;
    }

    public String getUserName() {
        return userName;
    }

    public Poker getMyMaxPoker() {
        return pokers.stream().reduce(Poker::compareTo).orElse(null);
    }

    public int getMyLevel() {
        if (isPair()) return PAIR_LEVEL;
        return HIGH_CARD_LEVEL;
    }

    private Boolean isPair() {
        List<String> list = pokers.stream().map(poker -> poker.getNumber()).collect(Collectors.toList());
        return list.stream().distinct().count() != COUNT_POKERS;
    }
}
