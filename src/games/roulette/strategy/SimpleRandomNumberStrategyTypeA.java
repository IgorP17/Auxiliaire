package games.roulette.strategy;

import games.roulette.RouletteBetTable;
import games.roulette.enums.RouletteBetTypesEnum;

import java.util.Random;

public class SimpleRandomNumberStrategyTypeA extends Strategy {


    public SimpleRandomNumberStrategyTypeA(int total) {
        super(total);
    }

    /**
     * Bet on any random number
     *
     * @param betTable - bet table
     * @return - false if no bet made
     */
    @Override
    boolean bet(RouletteBetTable betTable) {
        // always define betAmount
        betAmount = RouletteBetTypesEnum.TYPE_A.getMinAmount();
        Random random = new Random();
        return betTable.doBetTypeA(random.nextInt(37), betAmount, this);
    }
}
