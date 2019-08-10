import java.util.List;

public class User {
    private String userName;
    private List<Poker> pokers;

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
        return 1;
    }
}
