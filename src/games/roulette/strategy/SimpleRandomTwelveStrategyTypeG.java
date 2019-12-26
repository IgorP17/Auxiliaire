package games.roulette.strategy;

import games.roulette.RouletteBetTable;
import games.roulette.enums.RandomEnum;
import games.roulette.enums.RouletteBetTypesEnum;
import games.roulette.enums.RouletteTwelvesEnum;

public class SimpleRandomTwelveStrategyTypeG extends Strategy{

    public SimpleRandomTwelveStrategyTypeG(int total) {
        super(total);
    }

    @Override
    boolean bet(RouletteBetTable betTable) {

        return betTable.doBet(
                RouletteBetTypesEnum.TYPE_G,
                RandomEnum.randomEnum(RouletteTwelvesEnum.class),
                RouletteBetTypesEnum.TYPE_G.getMinAmount(),
                this);
    }
}
