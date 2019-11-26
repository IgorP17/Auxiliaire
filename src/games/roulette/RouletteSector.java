package games.roulette;

import java.util.Objects;
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
    static RouletteSector getSectorByNumber(int num) {
        //switch
        switch (num) {
            case 0:
                return new RouletteSector(num, RouletteColorsEnum.ZERO);
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
            case 12:
            case 14:
            case 16:
            case 18:
            case 19:
            case 21:
            case 23:
            case 25:
            case 27:
            case 30:
            case 32:
            case 34:
            case 36:
                return new RouletteSector(num, RouletteColorsEnum.RED);
            case 2:
            case 4:
            case 6:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 20:
            case 22:
            case 24:
            case 26:
            case 28:
            case 29:
            case 31:
            case 33:
            case 35:
                return new RouletteSector(num, RouletteColorsEnum.BLACK);
            default:
                System.out.println("!!! num is not in [0..36]");
                return null;
        }

    }

    /**
     * Get random sector
     *
     * @return - random sector [0..37)
     */
    static RouletteSector getRandomSector() {
        Random random = new Random();
        // [0..37)
        return getSectorByNumber(random.nextInt(37));
    }


    // getters
    RouletteColorsEnum getColorsEnum() {
        return colorsEnum;
    }

    int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "RouletteSector{" +
                "colorsEnum=" + colorsEnum +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouletteSector sector = (RouletteSector) o;
        return number == sector.number &&
                colorsEnum == sector.colorsEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorsEnum, number);
    }
}
