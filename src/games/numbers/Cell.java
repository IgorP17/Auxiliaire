package games.numbers;

public class Cell {

    private final int value;
    private final String sValue;
    private boolean isEmpty;

    private static final String emptySymbol = "*";

    Cell(int value){
        this.value = value;
        this.sValue = String.valueOf(value);
        this.isEmpty = false;
    }


    public int getValue() {
        return value;
    }

    public String getsValue() {
        if (isEmpty)
                return emptySymbol;
        else
            return sValue;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(){
        isEmpty = true;
    }


}
