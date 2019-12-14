package games.roulette.strategy;

import games.roulette.RandomEnum;
import games.roulette.RouletteBetTable;
import games.roulette.RouletteBetTypesEnum;
import games.roulette.RouletteTriplesEnum;

public class SimpleRandomTriplesStrategyTypeC extends Strategy {

    public SimpleRandomTriplesStrategyTypeC(int total) {
        super(total);
    }

    @Override
    boolean bet(RouletteBetTable betTable) {
        betAmount = RouletteBetTypesEnum.TYPE_B.getMinAmount();

        return betTable.doBetTypeC(
                RandomEnum.randomEnum(RouletteTriplesEnum.class),
                betAmount,
                this);
    }
}
