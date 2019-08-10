import java.util.ArrayList;
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
        if(isPair()) return 2;
        return 1;
    }

    private Boolean isPair(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if(list.contains(pokers.get(i).getNumber())) return true;
            list.add(pokers.get(i).getNumber());
        }
        return false;
    }
}
