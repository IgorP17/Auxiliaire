package games.roulette;

public class RouletteSector {

    private RouletteColorsEnum colorsEnum;
    private int number;

    /**
     * Constructor is private since we will return RouletteSector later
     * @param number - number [0..36]
     * @param colorsEnum - color
     */
    private RouletteSector(int number, RouletteColorsEnum colorsEnum){
        this.colorsEnum = colorsEnum;
        this.number = number;
    }


    /**
     * Get sector by number
     * @param num - number [0..36]
     * @return - instance of RouletteSector
     */
    RouletteSector getSectorByNumber(int num){
        if (num == 0){
            return new RouletteSector(0, RouletteColorsEnum.ZERO);
        }//TODO
        return null;
    }


    // getters
    public RouletteColorsEnum getColorsEnum() {
        return colorsEnum;
    }

    public int getNumber() {
        return number;
    }
}
