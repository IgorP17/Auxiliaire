package games.roulette.strategy;

import games.roulette.IntegerGetable;
import games.roulette.RouletteBetTable;
import games.roulette.enums.RouletteBetTypesEnum;

import java.util.Random;

public class SimpleRandomNumberStrategyTypeA extends Strategy implements IntegerGetable{


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
        return betTable.doBet(
                RouletteBetTypesEnum.TYPE_A,
                this,
                RouletteBetTypesEnum.TYPE_A.getMinAmount(),
                this);
    }

    @Override
    public int[] getNumbers() {
        Random random = new Random();
        return new int[]{random.nextInt(37)};
    }
}
