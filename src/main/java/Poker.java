public class Poker {
    private PokerColor color;
    private String number;

    protected Poker(PokerColor color, String number) {
        this.color = color;
        this.number = number;
    }


    protected String compareTo(Poker poker) {
        if (Character.isDigit(this.number.charAt(0)) && Character.isDigit(poker.number.charAt(0))) {
            if (Integer.valueOf(this.number) > Integer.valueOf(poker.number)) return this.toString();
            else if (Integer.valueOf(this.number) == Integer.valueOf(poker.number)) return "平局";
            return poker.toString();
        } else {
            this.number = setNumber(this);
            poker.number = setNumber(poker);
            if (Integer.valueOf(this.number) > Integer.valueOf(poker.number)) return this.toString();
            else if (Integer.valueOf(this.number) == Integer.valueOf(poker.number)) return "平局";
            return poker.toString();
        }
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
