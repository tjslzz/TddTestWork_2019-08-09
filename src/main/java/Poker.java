public class Poker {
    private PokerColor color;
    private String number;

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

    private String setNumber(Poker poker) {
        switch (poker.number) {
            case "T":
                return "11";
            case "J":
                return "12";
            case "Q":
                return "13";
            case "K":
                return "14";
            case "A":
                return "15";
        }
        return poker.number;
    }

    private String getNumber() {
        switch (number) {
            case "11":
                return "T";
            case "12":
                return "J";
            case "13":
                return "Q";
            case "14":
                return "K";
            case "15":
                return "A";
        }
        return number;
    }
}
