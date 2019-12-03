package games.roulette;

import java.util.Random;

class SimpleRandomColorStrategyTypeH extends Strategy {


    SimpleRandomColorStrategyTypeH(int total) {
        super(total);
    }

    @Override
    boolean bet(RouletteBetTable betTable) {
        betAmount = total < RouletteBetTypesEnum.TYPE_H.getMinAmount() ?
                total : RouletteBetTypesEnum.TYPE_H.getMinAmount();

        Random random = new Random();
        int x = random.nextInt(2);
        switch (x) {
            case 0:
                return betTable.doBetTypeHRedBlack(RouletteColorsEnum.RED,
                        betAmount,
                        this);
            case 1:
                return betTable.doBetTypeHRedBlack(RouletteColorsEnum.BLACK,
                        betAmount,
                        this);
            default:
                System.out.println("!!! Error out of range");
                return false;
        }
    }

}
