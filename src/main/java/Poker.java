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
}
