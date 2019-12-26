package games.roulette.strategy;

import games.roulette.RouletteBetTable;
import games.roulette.enums.RandomEnum;
import games.roulette.enums.RouletteBetTypesEnum;
import games.roulette.enums.RouletteFoursEnum;

public class SimpleRandomFoursStrategyTypeD extends Strategy {


    public SimpleRandomFoursStrategyTypeD(int total) {
        super(total);
    }

    @Override
    boolean bet(RouletteBetTable betTable) {

        return betTable.doBet(
                RouletteBetTypesEnum.TYPE_D,
                RandomEnum.randomEnum(RouletteFoursEnum.class),
                RouletteBetTypesEnum.TYPE_D.getMinAmount(),
                this);
    }
}
