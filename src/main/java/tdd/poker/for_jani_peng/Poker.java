package tdd.poker.for_jani_peng;

public class Poker {
    private PokerColor color;
    private String number;

    protected Poker compareTo(Poker poker) {
        this.number = setNumber(this);
        poker.number = setNumber(poker);
        if (Integer.valueOf(this.number) == Integer.valueOf(poker.number)) {
            this.color = PokerColor.平局;
            return this;
        } else if (Integer.valueOf(this.number) > Integer.valueOf(poker.number)) return this;
        return poker;
    }

    public String setNumber(Poker poker) {
        switch (poker.number) {
            case "T":
                return Common.T_LEVEL;
            case "J":
                return Common.J_LEVEL;
            case "Q":
                return Common.Q_LEVEL;
            case "K":
                return Common.K_LEVEL;
            case "A":
                return Common.A_LEVEL;
        }
        return poker.number;
    }

    public String getNumber() {
        switch (number) {
            case Common.T_LEVEL:
                return "T";
            case Common.J_LEVEL:
                return "J";
            case Common.Q_LEVEL:
                return "Q";
            case Common.K_LEVEL:
                return "K";
            case Common.A_LEVEL:
                return "A";
        }
        return number;
    }

    public String toString() {
        return this.getNumber() + this.color;
    }

    public String getColor() {
        return color.name();
    }

    protected Poker(PokerColor color, String number) {
        this.color = color;
        this.number = number;
    }
}
