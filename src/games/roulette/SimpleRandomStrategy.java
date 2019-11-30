package games.roulette;

import java.util.Random;

class SimpleRandomStrategy extends Strategy {


    SimpleRandomStrategy(int total) {
        super(total);
    }

    @Override
    int bet(RouletteBetTable betTable) {
        Random random = new Random();
        int x = random.nextInt(2);
        switch (x) {
            case 0:
                betTable.doBetTypeHRedBlack(RouletteColorsEnum.RED,
                        RouletteBetTypesEnum.TYPE_H.getMinAmount(),
                        this);
                return RouletteBetTypesEnum.TYPE_H.getMinAmount();
            case 1:
                betTable.doBetTypeHRedBlack(RouletteColorsEnum.BLACK,
                        RouletteBetTypesEnum.TYPE_H.getMinAmount(),
                        this);
                return RouletteBetTypesEnum.TYPE_H.getMinAmount();
            default:
                System.out.println("!!! Error out of range");
                return 0;
        }
    }
}
