public class Poker {
    private PokerColor color;
    private String number;
    private static final String T_LEVEL = "11";
    private static final String J_LEVEL = "12";
    private static final String Q_LEVEL = "13";
    private static final String K_LEVEL = "14";
    private static final String A_LEVEL = "15";

    protected Poker(PokerColor color, String number) {
        this.color = color;
        this.number = number;
    }

    protected Poker compareTo(Poker poker) {
        this.number = setNumber(this);
        poker.number = setNumber(poker);
        if (Integer.valueOf(this.number) == Integer.valueOf(poker.number)) {
            this.color = PokerColor.平局;
            return this;
        } else if (Integer.valueOf(this.number) > Integer.valueOf(poker.number)) return this;
        return poker;
    }

    public String toString() {
        return this.getNumber() + this.color;
    }

    public String getColor() { return color.name(); }

    private String setNumber(Poker poker) {
        switch (poker.number) {
            case "T":
                return T_LEVEL;
            case "J":
                return J_LEVEL;
            case "Q":
                return Q_LEVEL;
            case "K":
                return K_LEVEL;
            case "A":
                return A_LEVEL;
        }
        return poker.number;
    }

    public String getNumber() {
        switch (number) {
            case T_LEVEL:
                return "T";
            case J_LEVEL:
                return "J";
            case Q_LEVEL:
                return "Q";
            case K_LEVEL:
                return "K";
            case A_LEVEL:
                return "A";
        }
        return number;
    }
}
