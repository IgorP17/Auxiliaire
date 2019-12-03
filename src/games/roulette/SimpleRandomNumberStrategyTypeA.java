package games.roulette;

import java.util.Random;

class SimpleRandomNumberStrategyTypeA extends Strategy {


    SimpleRandomNumberStrategyTypeA(int total) {
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
