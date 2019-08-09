public class Poker {
    private String color;
    private String number;

    public Poker() {
    }

    public Poker(String color, String number) {
        this.color = color;
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
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

    public Poker compareTo(Poker poker){
        if(Character.isDigit(this.number.charAt(0)) && Character.isDigit(poker.getNumber().charAt(0))){
            if(Integer.valueOf(this.number) > Integer.valueOf(poker.getNumber()))
                return this;
            return poker;
        }
        return null;
    }
}
