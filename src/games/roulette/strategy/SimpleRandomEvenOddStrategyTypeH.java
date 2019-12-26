package games.roulette.strategy;

import games.roulette.RouletteBetTable;
import games.roulette.enums.RandomEnum;
import games.roulette.enums.RouletteBetTypesEnum;
import games.roulette.enums.RouletteEvenOddEnum;


public class SimpleRandomEvenOddStrategyTypeH extends Strategy {

    public SimpleRandomEvenOddStrategyTypeH(int total) {
        super(total);
    }

    @Override
    boolean bet(RouletteBetTable betTable) {

        return betTable.doBet(
                RouletteBetTypesEnum.TYPE_H,
                RandomEnum.randomEnum(RouletteEvenOddEnum.class),
                RouletteBetTypesEnum.TYPE_H.getMinAmount(),
                this);
    }
}
