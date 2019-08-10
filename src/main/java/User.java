import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private String userName;
    private List<Poker> pokers;
    private static final Long COUNT_PAIR = 4L;
    private static final Long COUNT_TWO_PAIR = 3L;
    private static final int COUNT_THREE_KIND = 3;
    private static final int HIGH_CARD_LEVEL = 1;
    private static final int PAIR_LEVEL = 2;
    private static final int TWO_PAIR_LEVEL = 3;
    private static final int THREE_KIND_LEVEL = 4;

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
        if (isThreeKind()) return THREE_KIND_LEVEL;
        if (isTwoPair()) return TWO_PAIR_LEVEL;
        if (isPair()) return PAIR_LEVEL;
        return HIGH_CARD_LEVEL;
    }

    private Boolean isPair() {
        List<String> list = pokers.stream().map(poker -> poker.getNumber()).collect(Collectors.toList());
        return list.stream().distinct().count() == COUNT_PAIR;
    }

    private Boolean isTwoPair() {
        List<String> list = pokers.stream().map(poker -> poker.getNumber()).collect(Collectors.toList());
        return list.stream().distinct().count() == COUNT_TWO_PAIR;
    }

    private Boolean isThreeKind() {
        int max = 1;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < pokers.size(); i++) {
            if (list.contains(pokers.get(i).getNumber())) {
                max++;
            } else {
                list.add(pokers.get(i).getNumber());
            }
        }
        return max == COUNT_THREE_KIND;
    }
}
