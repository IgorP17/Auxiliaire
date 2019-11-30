package games.roulette;

import java.util.Random;

class SimpleRandomStrategy extends Strategy {


    SimpleRandomStrategy(int total) {
        super(total);
    }

    @Override
    int bet(RouletteBetTable betTable) {
        int amount = total <  RouletteBetTypesEnum.TYPE_H.getMinAmount() ?
                total : RouletteBetTypesEnum.TYPE_H.getMinAmount();

        Random random = new Random();
        int x = random.nextInt(2);
        switch (x) {
            case 0:
                betTable.doBetTypeHRedBlack(RouletteColorsEnum.RED,
                        amount,
                        this);
                break;
            case 1:
                betTable.doBetTypeHRedBlack(RouletteColorsEnum.BLACK,
                        amount,
                        this);
                break;
            default:
                System.out.println("!!! Error out of range");
                return 0;
        }
        return amount;
    }

}
