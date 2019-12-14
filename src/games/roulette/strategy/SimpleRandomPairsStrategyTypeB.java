package games.roulette.strategy;

import games.roulette.RandomEnum;
import games.roulette.RouletteBetTable;
import games.roulette.RouletteBetTypesEnum;
import games.roulette.RoulettePairsEnum;

public class SimpleRandomPairsStrategyTypeB extends Strategy {

    public SimpleRandomPairsStrategyTypeB(int total) {
        super(total);
    }

    @Override
    boolean bet(RouletteBetTable betTable) {
        betAmount = RouletteBetTypesEnum.TYPE_B.getMinAmount();

        return betTable.doBetTypeB(
                RandomEnum.randomEnum(RoulettePairsEnum.class),
                betAmount,
                this);
    }
}
