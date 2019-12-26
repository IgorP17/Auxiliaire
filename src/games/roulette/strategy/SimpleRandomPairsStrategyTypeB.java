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

        return betTable.doBet(
                RouletteBetTypesEnum.TYPE_B,
                RandomEnum.randomEnum(RoulettePairsEnum.class),
                RouletteBetTypesEnum.TYPE_B.getMinAmount(),
                this);
    }
}
