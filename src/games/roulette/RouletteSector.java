package games.roulette;

import java.util.Random;

/**
 * This is class for
 * 1. Generate random sector
 */

class RouletteSector {

    private RouletteColorsEnum colorsEnum;
    private int number;

    /**
     * Constructor is private since we will return RouletteSector later
     *
     * @param number     - number [0..36]
     * @param colorsEnum - color
     */
    private RouletteSector(int number, RouletteColorsEnum colorsEnum) {
        this.colorsEnum = colorsEnum;
        this.number = number;
    }


    /**
     * Get sector by number
     *
     * @param num - number [0..36]
     * @return - instance of RouletteSector
     */
    private RouletteSector getSectorByNumber(int num) {
        // check range
        if (num > 36 || num < 0) {
            System.out.println("!!! num is not in [0..36]");
            return null;
        }

        if (num == 0) { // zero
            return new RouletteSector(0, RouletteColorsEnum.ZERO);
        } else if (num % 2 == 0) { // black is divide by 2
            return new RouletteSector(num, RouletteColorsEnum.BLACK);
        } else { // red otherwise
            return new RouletteSector(num, RouletteColorsEnum.RED);
        }
    }

    /**
     * Get random sector
     * @return - random sector [0..37)
     */
    RouletteSector getRandomSector(){
        Random random = new Random();
        // [0..37)
        return getSectorByNumber(random.nextInt(37));
    }


    // getters
    public RouletteColorsEnum getColorsEnum() {
        return colorsEnum;
    }

    public int getNumber() {
        return number;
    }
}
