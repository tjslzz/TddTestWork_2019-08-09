import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private String userName;
    private List<Poker> pokers;
    private static final int IS_POKER_SIZE = 5;
    private static final int IS_ONE_PAIR = 4;
    private static final int IS_FOUR_KIND = 4;
    private static final int IS_THREE_KIND = 3;
    private static final int IS_FULL_HOUSE = 2;
    private static final Long IS_FLUSH = 1L;
    private int maxPoker = 0;

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

    Poker getMyMaxPoker() {
        return pokers.stream().reduce(Poker::compareTo).orElse(null);
    }

    public int getMaxPoker() {
        return maxPoker;
    }

    public int getMyLevel() {
        maxPoker = Integer.valueOf(getMyMaxPoker().setNumber(getMyMaxPoker()));
        if (isFlush()) return isStraight() ? Common.STRAIGHT_FLUSH_LEVEL : Common.FLUSH_LEVEL;
        return isStraight() ? Common.STRAIGHT_LEVEL : duplicateLevel();
    }

    private Boolean isFlush() {
        List<String> list = pokers.stream().map(Poker::getColor).collect(Collectors.toList());
        return list.stream().distinct().count() == IS_FLUSH;
    }

    private int duplicateLevel() {
        int maxDuplicate = 2;
        List<String> list = new ArrayList<>();
        maxDuplicate = getMaxDuplicate(maxDuplicate, list);
        return getDuplicateLevel(maxDuplicate, list);
    }

    private int getMaxDuplicate(int max, List<String> list) {
        String temp = "";
        for (Poker poker : pokers) {
            if (list.contains(poker.getNumber())) {
                if (temp.equalsIgnoreCase(poker.getNumber())) max++;
                else temp = poker.getNumber();
            } else list.add(poker.getNumber());
        }
        if (maxPoker < Integer.valueOf(temp)) maxPoker = Integer.valueOf(temp);
        return max;
    }

    private int getDuplicateLevel(int max, List<String> list) {
        switch (list.size()) {
            case IS_POKER_SIZE:
                return Common.HIGH_CARD_LEVEL;
            case IS_ONE_PAIR:
                return Common.PAIR_LEVEL;
            case IS_FULL_HOUSE:
                return max == IS_FOUR_KIND ? Common.FOUR_KIND_LEVEL : Common.FULL_HOUSE_LEVEL;
        }
        return max == IS_THREE_KIND ? Common.THREE_KIND_LEVEL : Common.TWO_PAIR_LEVEL;
    }

    private Boolean isStraight() {
        List<Integer> list = pokers.stream().mapToInt(poker -> Integer.valueOf(poker.setNumber(poker))).boxed().collect(Collectors.toList());
        int min = Collections.min(list);
        for (int i = 0; i < 5; i++) {
            if (list.contains(min)) min++;
            else return false;
        }
        maxPoker = min;
        return true;
    }
}
