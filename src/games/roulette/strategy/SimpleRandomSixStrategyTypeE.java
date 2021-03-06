package games.roulette.strategy;

import games.roulette.RouletteBetTable;
import games.roulette.enums.RandomEnum;
import games.roulette.enums.RouletteBetTypesEnum;
import games.roulette.enums.RouletteSixEnum;

public class SimpleRandomSixStrategyTypeE extends Strategy  {
    public SimpleRandomSixStrategyTypeE(int total) {
        super(total);
    }

    @Override
    boolean bet(RouletteBetTable betTable) {

        return betTable.doBet(
                RouletteBetTypesEnum.TYPE_E,
                RandomEnum.randomEnum(RouletteSixEnum.class),
                RouletteBetTypesEnum.TYPE_E.getMinAmount(),
                this);
    }
}
