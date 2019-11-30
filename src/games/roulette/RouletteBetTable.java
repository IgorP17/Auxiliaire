package games.roulette;

import java.util.ArrayList;

class RouletteBetTable {

    private ArrayList<RouletteBetItem> bets = new ArrayList<>();

    /**
     * Direct bet on the number
     *
     * @param number   - roulette number
     * @param amount   - amount
     * @param strategy - calling class
     * @return - true if bet set, false otherwise
     */
    boolean doBetTypeA(int number, int amount, Strategy strategy) {
        if (amount < RouletteBetTypesEnum.TYPE_A.getMinAmount() ||
                amount > RouletteBetTypesEnum.TYPE_A.getMaxAmount()) {
            System.out.println("!!! Wrong bet amount for type A");
            return false;
        }
        bets.add(new RouletteBetItem(
                RouletteSector.getSectorByNumber(number),
                RouletteBetTypesEnum.TYPE_A,
                amount,
                amount * RouletteBetTypesEnum.TYPE_A.getPayRoll(),
                strategy));
        return true;
    }

    /**
     * Bet on RED or BLACK
     *
     * @param color    - RED or BLACK
     * @param amount   - amount
     * @param strategy - calling class
     * @return - true if bet set, false otherwise
     */
    boolean doBetTypeHRedBlack(RouletteColorsEnum color, int amount, Strategy strategy) {
        if (amount < RouletteBetTypesEnum.TYPE_H.getMinAmount() ||
                amount > RouletteBetTypesEnum.TYPE_H.getMaxAmount()) {
            System.out.println("!!! Wrong bet amount for type H");
            return false;
        }
        // make a bet on all number which has the same color
        // do not include ZERO
        RouletteSector sector;
        for (int i = 1; i < 37; i++) {
            sector = RouletteSector.getSectorByNumber(i);
            assert sector != null;
            if (color == sector.getColorsEnum()) {
                bets.add(new RouletteBetItem(
                        sector,
                        RouletteBetTypesEnum.TYPE_H,
                        amount,
                        amount * RouletteBetTypesEnum.TYPE_H.getPayRoll(),
                        strategy));
            }
        }
        return true;
    }

    /**
     * Clean all bets
     */
    void cleanBets(){
        bets.clear();
    }

    // getters
    ArrayList<RouletteBetItem> getBets() {
        return bets;
    }

}
