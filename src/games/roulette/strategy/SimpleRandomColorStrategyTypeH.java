package games.roulette.strategy;

import games.roulette.RouletteBetTable;
import games.roulette.enums.RandomEnum;
import games.roulette.enums.RouletteBetTypesEnum;
import games.roulette.enums.RouletteRedBlackEnum;


public class SimpleRandomColorStrategyTypeH extends Strategy {


    public SimpleRandomColorStrategyTypeH(int total) {
        super(total);
    }

    @Override
    boolean bet(RouletteBetTable betTable) {
        betAmount = RouletteBetTypesEnum.TYPE_H.getMinAmount();

        return betTable.doBet(
                RouletteBetTypesEnum.TYPE_H,
                RandomEnum.randomEnum(RouletteRedBlackEnum.class),
                betAmount,
                this);
    }
}
