package games.numbers;

public class Cell {

    private int value;
    private String sValue;
    private boolean empty;

    private static final String emptySymbol = "*";

    Cell(int value){
        this.value = value;
        this.sValue = String.valueOf(value);
        this.empty = false;
    }


    public int getValue() {
        return value;
    }

    public String getsValue() {
        if (empty)
                return emptySymbol;
        else
            return sValue;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(){
        empty = true;
    }


}
