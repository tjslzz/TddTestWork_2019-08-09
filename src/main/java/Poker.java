public class Poker {
    private PokerColor color;
    private String number;

    public Poker() {
    }

    public Poker(PokerColor color, String number) {
        this.color = color;
        this.number = number;
    }

    public PokerColor getColor() {
        return color;
    }

    public void setColor(PokerColor color) {
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String toString(){
        return this.number+this.color;
    }

    public String compareTo(Poker poker){
        if(Character.isDigit(this.number.charAt(0)) && Character.isDigit(poker.getNumber().charAt(0))){
            if(Integer.valueOf(this.number) > Integer.valueOf(poker.getNumber()))
                return this.toString();
            else if(Integer.valueOf(this.number) == Integer.valueOf(poker.getNumber()))
                return "平局";
            return poker.toString();
        }
        return null;
    }
}
