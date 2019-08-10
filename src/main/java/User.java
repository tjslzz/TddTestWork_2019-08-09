import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private String userName;
    private List<Poker> pokers;
    private static final int IS_ONE_PAIR = 4;
    private static final int IS_THREE_KIND = 3;
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
        return duplicateLevel();
    }

    private int duplicateLevel() {
        int max = 2;
        String temp = "";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < pokers.size(); i++) {
            if (list.contains(pokers.get(i).getNumber())) {
                if (temp.equalsIgnoreCase(pokers.get(i).getNumber())) max++;
                else temp = pokers.get(i).getNumber();
            } else list.add(pokers.get(i).getNumber());
        }
        if (list.size() == pokers.size()) return HIGH_CARD_LEVEL;
        else {
            if (list.size() == IS_ONE_PAIR) return PAIR_LEVEL;
            else return max == IS_THREE_KIND ? THREE_KIND_LEVEL : TWO_PAIR_LEVEL;
        }
    }
}
