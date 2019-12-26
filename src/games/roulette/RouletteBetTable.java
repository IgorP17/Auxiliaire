package games.roulette;

import games.roulette.enums.*;
import games.roulette.strategy.Strategy;

import java.util.ArrayList;

public class RouletteBetTable {

    private ArrayList<RouletteBetItem> bets = new ArrayList<>();

    /**
     * Do bet
     *
     * @param rouletteBetTypesEnum - bet type
     * @param integerGetable       - enum, that can return numbers for bet
     * @param amount               - amount
     * @param strategy             - strategy
     * @return - if bet set
     */
    public boolean doBet(RouletteBetTypesEnum rouletteBetTypesEnum,
                         IntegerGetable integerGetable,
                         int amount,
                         Strategy strategy) {

        if (amount < rouletteBetTypesEnum.getMinAmount() ||
                amount > rouletteBetTypesEnum.getMaxAmount()) {
            System.out.println("!!! Wrong bet amount for type " + rouletteBetTypesEnum.toString());
            return false;
        }

        for (int i :
                integerGetable.getNumbers()) {
            bets.add(new RouletteBetItem(
                    RouletteSector.getSectorByNumber(i),
                    rouletteBetTypesEnum,
                    amount,
                    amount * rouletteBetTypesEnum.getPayRoll(),
                    strategy));
        }

        // call decrease totals
        strategy.doBetDecrease(amount);

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
