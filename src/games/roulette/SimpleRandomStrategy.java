package games.roulette;

import java.util.Random;

public class SimpleRandomStrategy extends Strategy {


    @Override
    boolean bet(RouletteBetTable betTable) {
        Random random = new Random();
        int x = random.nextInt(2);
        switch (x) {
            case 0:
                return betTable.doBetTypeHRedBlack(RouletteColorsEnum.RED,
                        RouletteBetTypesEnum.TYPE_H.getMinAmount(),
                        this.getClass().getName());
            case 1:
                return betTable.doBetTypeHRedBlack(RouletteColorsEnum.BLACK,
                        RouletteBetTypesEnum.TYPE_H.getMinAmount(),
                        this.getClass().getSimpleName());
            default:
                System.out.println("!!! Error out of range");
                return false;
        }
    }
}
