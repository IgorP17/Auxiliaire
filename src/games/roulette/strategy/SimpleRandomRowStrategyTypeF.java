package games.roulette.strategy;

import games.roulette.RouletteBetTable;
import games.roulette.enums.RandomEnum;
import games.roulette.enums.RouletteBetTypesEnum;
import games.roulette.enums.RouletteRowEnum;

public class SimpleRandomRowStrategyTypeF extends Strategy {

    public SimpleRandomRowStrategyTypeF(int total) {
        super(total);
    }

    @Override
    boolean bet(RouletteBetTable betTable) {

        return betTable.doBet(
                RouletteBetTypesEnum.TYPE_F,
                RandomEnum.randomEnum(RouletteRowEnum.class),
                RouletteBetTypesEnum.TYPE_F.getMinAmount(),
                this);
    }
}
