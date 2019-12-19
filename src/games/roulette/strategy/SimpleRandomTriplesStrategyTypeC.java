package games.roulette.strategy;

import games.roulette.enums.RandomEnum;
import games.roulette.RouletteBetTable;
import games.roulette.enums.RouletteBetTypesEnum;
import games.roulette.enums.RouletteTriplesEnum;

public class SimpleRandomTriplesStrategyTypeC extends Strategy {

    public SimpleRandomTriplesStrategyTypeC(int total) {
        super(total);
    }

    @Override
    boolean bet(RouletteBetTable betTable) {
        betAmount = RouletteBetTypesEnum.TYPE_C.getMinAmount();

        return betTable.doBet(
                RouletteBetTypesEnum.TYPE_C,
                RandomEnum.randomEnum(RouletteTriplesEnum.class),
                betAmount,
                this);
    }
}
