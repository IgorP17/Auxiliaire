package games.sudoku;

import java.util.ArrayList;
import java.util.Arrays;

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
    //
    private int threeID = -1;

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

        // detect 3x3 square id
        // 0 1 2
        // 3 4 5
        // 6 7 8
        if (posI <= 2){
            if (posJ <= 2){
                threeID = 0;
            } else if (posJ <= 5){
                threeID = 1;
            } else {
                threeID = 2;
            }
        } else if (posI <= 5){
            if (posJ <= 2){
                threeID = 3;
            } else if (posJ <= 5){
                threeID = 4;
            } else {
                threeID = 5;
            }
        } else {
            if (posJ <= 2){
                threeID = 6;
            } else if (posJ <= 5){
                threeID = 7;
            } else {
                threeID = 8;
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Integer i :
                candidates) {
            s.append(i).append(";");
        }
        return
                String.format("[%d][%d], filled = %s, v = %s, 3x3 id = %d, candidates = %s",
                        posI,
                        posJ,
                        filled ? "1" : "0",
                        value == null ? "_" : value,
                        threeID,
                        s);
    }

    /**
     * Is cell filled with value
     *
     * @return - is filled
     */
    boolean isFilled() {
        return filled;
    }

    /**
     * Get filled value
     *
     * @return - value or null if not filled
     */
    Integer getValue() {
        return value;
    }

    /**
     * Set value to cell
     *
     * @param value - int value
     */
    public void setValue(Integer value) {
        if (this.filled) {
            throw new RuntimeException("Attempt to set value to filled cell!");
        }
        this.filled = true;
        this.value = value;
    }

    /**
     * Remove candidate from cell
     *
     * @param c
     */
    void removeCandidate(Integer c) {
        candidates.remove(c);
    }

    /**
     * Set all possible candidates
     */
    void fillAllCandidates(){
        candidates = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    public int getThreeID() {
        return threeID;
    }
}
