package games.sudoku;

import java.util.ArrayList;

/**
 * Class cell
 * <p>
 * Cell can be filled with some value or not
 */
public class Cell {

    // pos i j
    private int posI, posJ;
    // is cell filled with value
    private boolean filled;
    // filled value, otherwise null
    private Integer value;
    // candidates
    private ArrayList<Integer> candidates = new ArrayList<>();

    /**
     * Constructor
     *
     * @param filled - is filled
     * @param value  - filled with value
     */
    Cell(boolean filled, Integer value, int posI, int posJ) {
        this.posI = posI;
        this.posJ = posJ;

        if (filled) {
            if (value == null) {
                throw new RuntimeException("Attempt to fill cell with null!");
            } else {
                this.filled = true;
                this.value = value;
            }
        } else {
            this.filled = false;
            this.value = null;
        }

    }

    @Override
    //TODO
    public String toString(){
        return
                String.format("[%d][%d], filled = %s, v = %s",
                        posI,
                        posJ,
                        filled ? "1" : "0",
                        value == null ? "_" : value);
    }

    /**
     * Is cell filled with value
     * @return - is filled
     */
    boolean isFilled() {
        return filled;
    }

    /**
     * Get filled value
     * @return - value or null if not filled
     */
    Integer getValue() {
        return value;
    }

    /**
     * Set value to cell
     * @param value - int value
     */
    public void setValue(Integer value) {
        if (this.filled){
            throw new RuntimeException("Attempt to set value to filled cell!");
        }
        this.filled = true;
        this.value = value;
    }

    /**
     * Add candidate value to cell
     * @param c - candidate int
     */
    void addCandidate(Integer c){
        candidates.add(c);
    }

    /**
     * Remove candidate from cell
     * @param c
     */
    void removeCandidate(Integer c){
        candidates.remove(c);
    }
}
