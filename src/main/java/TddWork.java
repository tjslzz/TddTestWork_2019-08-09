public class TddWork {
    public String judges(Poker poker1,Poker poker2){
        if(Integer.valueOf(poker1.getNumber()) > Integer.valueOf(poker2.getNumber()))
            return poker1.toString();
        return poker2.toString();
    }
}
