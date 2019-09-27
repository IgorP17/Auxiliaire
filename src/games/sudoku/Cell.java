package games.sudoku;

/**
 * Class cell
 * <p>
 * Cell can be filled with some value or not
 */
public class Cell {

    // is cell filled with value
    private boolean filled;
    // filled value, otherwise null
    private Integer value;

    /**
     * Constructor
     *
     * @param filled - is filled
     * @param value  - filled with value
     */
    Cell(boolean filled, Integer value) {

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

    /**
     * Is cell filled with value
     * @return - is filled
     */
    public boolean isFilled() {
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
}
