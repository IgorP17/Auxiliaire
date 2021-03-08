package games.numbers;

public class Cell {

    private final int value;
    private final String sValue;
    private boolean isEmpty;
    private boolean isLast;

    private static final String emptySymbol = "*";
    private static final String lastSymbol = "_";

    Cell(int value) {
        this.value = value;
        this.sValue = String.valueOf(value);
        this.isEmpty = false;
        this.isLast = false;
    }


    public int getValue() {
        return value;
    }

    public String getsValue() {
        if (isLast)
            return lastSymbol;
        else if (isEmpty)
            return emptySymbol;
        else
            return sValue;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty() {
        isEmpty = true;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

}
