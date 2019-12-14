package games.roulette.strategy;

import games.roulette.enums.RandomEnum;
import games.roulette.RouletteBetTable;
import games.roulette.enums.RouletteBetTypesEnum;
import games.roulette.enums.RoulettePairsEnum;

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
