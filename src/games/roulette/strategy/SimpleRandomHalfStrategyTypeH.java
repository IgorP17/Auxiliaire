package games.roulette.strategy;

import games.roulette.RouletteBetTable;
import games.roulette.enums.RandomEnum;
import games.roulette.enums.RouletteBetTypesEnum;
import games.roulette.enums.RouletteEvenOddEnum;
import games.roulette.enums.RouletteHalfEnum;


public class SimpleRandomHalfStrategyTypeH extends Strategy {

    public SimpleRandomHalfStrategyTypeH(int total) {
        super(total);
    }

    @Override
    boolean bet(RouletteBetTable betTable) {
        betAmount = RouletteBetTypesEnum.TYPE_H.getMinAmount();

        return betTable.doBet(
                RouletteBetTypesEnum.TYPE_H,
                RandomEnum.randomEnum(RouletteHalfEnum.class),
                betAmount,
                this);
    }
}
