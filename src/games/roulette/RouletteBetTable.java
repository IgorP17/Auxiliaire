package games.roulette;

import games.roulette.enums.*;
import games.roulette.strategy.Strategy;

import java.util.ArrayList;

public class RouletteBetTable {

    private ArrayList<RouletteBetItem> bets = new ArrayList<>();

    /**
     * Direct bet on the number
     *
     * @param number   - roulette number
     * @param amount   - amount
     * @param strategy - calling class
     * @return - true if bet set, false otherwise
     */
    public boolean doBetTypeA(int number, int amount, Strategy strategy) {
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
     * Bet on pairs
     *
     * @param pairsEnum - pairs
     * @param amount    - amount
     * @param strategy  - calling class
     * @return - true if bet set, false otherwise
     */
    public boolean doBetTypeB(RoulettePairsEnum pairsEnum, int amount, Strategy strategy) {
        if (amount < RouletteBetTypesEnum.TYPE_B.getMinAmount() ||
                amount > RouletteBetTypesEnum.TYPE_B.getMaxAmount()) {
            System.out.println("!!! Wrong bet amount for type B");
            return false;
        }
        bets.add(new RouletteBetItem(
                RouletteSector.getSectorByNumber(pairsEnum.getA()),
                RouletteBetTypesEnum.TYPE_B,
                amount,
                amount * RouletteBetTypesEnum.TYPE_B.getPayRoll(),
                strategy));
        bets.add(new RouletteBetItem(
                RouletteSector.getSectorByNumber(pairsEnum.getB()),
                RouletteBetTypesEnum.TYPE_B,
                amount,
                amount * RouletteBetTypesEnum.TYPE_B.getPayRoll(),
                strategy));
        return true;
    }

    /**
     * Bet on triples
     *
     * @param triplesEnum - triple
     * @param amount      - amount
     * @param strategy    - calling class
     * @return - true if bet set, false otherwise
     */
    public boolean doBetTypeC(RouletteTriplesEnum triplesEnum, int amount, Strategy strategy) {
        if (amount < RouletteBetTypesEnum.TYPE_C.getMinAmount() ||
                amount > RouletteBetTypesEnum.TYPE_C.getMaxAmount()) {
            System.out.println("!!! Wrong bet amount for type C");
            return false;
        }
        bets.add(new RouletteBetItem(
                RouletteSector.getSectorByNumber(triplesEnum.getA()),
                RouletteBetTypesEnum.TYPE_C,
                amount,
                amount * RouletteBetTypesEnum.TYPE_C.getPayRoll(),
                strategy));
        bets.add(new RouletteBetItem(
                RouletteSector.getSectorByNumber(triplesEnum.getB()),
                RouletteBetTypesEnum.TYPE_C,
                amount,
                amount * RouletteBetTypesEnum.TYPE_C.getPayRoll(),
                strategy));
        bets.add(new RouletteBetItem(
                RouletteSector.getSectorByNumber(triplesEnum.getC()),
                RouletteBetTypesEnum.TYPE_C,
                amount,
                amount * RouletteBetTypesEnum.TYPE_C.getPayRoll(),
                strategy));
        return true;
    }


    /**
     * Bet on fours
     * @param rouletteFoursEnum - fours
     * @param amount - amount
     * @param strategy - calling class
     * @return - true if bet set, false otherwise
     */
    public boolean doBetTypeD(RouletteFoursEnum rouletteFoursEnum, int amount, Strategy strategy) {
        if (amount < RouletteBetTypesEnum.TYPE_D.getMinAmount() ||
                amount > RouletteBetTypesEnum.TYPE_D.getMaxAmount()) {
            System.out.println("!!! Wrong bet amount for type D");
            return false;
        }

        bets.add(new RouletteBetItem(
                RouletteSector.getSectorByNumber(rouletteFoursEnum.getA()),
                RouletteBetTypesEnum.TYPE_D,
                amount,
                amount * RouletteBetTypesEnum.TYPE_D.getPayRoll(),
                strategy));

        bets.add(new RouletteBetItem(
                RouletteSector.getSectorByNumber(rouletteFoursEnum.getB()),
                RouletteBetTypesEnum.TYPE_D,
                amount,
                amount * RouletteBetTypesEnum.TYPE_D.getPayRoll(),
                strategy));

        bets.add(new RouletteBetItem(
                RouletteSector.getSectorByNumber(rouletteFoursEnum.getC()),
                RouletteBetTypesEnum.TYPE_D,
                amount,
                amount * RouletteBetTypesEnum.TYPE_D.getPayRoll(),
                strategy));
        bets.add(new RouletteBetItem(
                RouletteSector.getSectorByNumber(rouletteFoursEnum.getD()),
                RouletteBetTypesEnum.TYPE_D,
                amount,
                amount * RouletteBetTypesEnum.TYPE_D.getPayRoll(),
                strategy));
        return true;
    }

    /**
     * Bet on six (2 x 3)
     * @param rouletteSixEnum - six
     * @param amount - amount
     * @param strategy - calling class
     * @return - true if bet set, false otherwise
     */
    public boolean doBetTypeE(RouletteSixEnum rouletteSixEnum, int amount, Strategy strategy) {
        if (amount < RouletteBetTypesEnum.TYPE_E.getMinAmount() ||
                amount > RouletteBetTypesEnum.TYPE_E.getMaxAmount()) {
            System.out.println("!!! Wrong bet amount for type E");
            return false;
        }

        for (int i:
             rouletteSixEnum.getNumbers()) {
            bets.add(new RouletteBetItem(
                    RouletteSector.getSectorByNumber(i),
                    RouletteBetTypesEnum.TYPE_E,
                    amount,
                    amount * RouletteBetTypesEnum.TYPE_E.getPayRoll(),
                    strategy));
        }


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
    public boolean doBetTypeHRedBlack(RouletteColorsEnum color, int amount, Strategy strategy) {
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
    void cleanBets() {
        bets.clear();
    }

    // getters
    ArrayList<RouletteBetItem> getBets() {
        return bets;
    }

}
