package games.roulette.strategy;

import games.roulette.RouletteBetTable;
import games.roulette.RouletteSector;
import games.roulette.enums.RandomEnum;
import games.roulette.enums.RouletteBetTypesEnum;
import games.roulette.enums.RouletteTwelvesEnum;

public class FirstTwoTwelvesStrategy extends Strategy {

    private int bet = RouletteBetTypesEnum.TYPE_G.getMinAmount();

    public FirstTwoTwelvesStrategy(int total) {
        super(total);
    }

    /**
     * Do a bets on 2 twelves
     * @param betTable - bet table
     * @return - true if all bets set up
     */
    @Override
    boolean bet(RouletteBetTable betTable) {
        boolean result;

        // do a bet on first 12
        result = betTable.doBet(
                RouletteBetTypesEnum.TYPE_G,
                RouletteTwelvesEnum.FIRST_12,
                bet,
                this);
        if (!result)
            return false;
        // do a bet on second 12
        result = betTable.doBet(
                RouletteBetTypesEnum.TYPE_G,
                RouletteTwelvesEnum.SECOND_12,
                bet,
                this);
        return result;
    }

    // TODO x2 bets in case we have second loose
}
