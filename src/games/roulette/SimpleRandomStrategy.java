package games.roulette;

import java.util.Random;

class SimpleRandomStrategy extends Strategy {


    @Override
    boolean bet(RouletteBetTable betTable) {
        Random random = new Random();
        int x = random.nextInt(2);
        switch (x) {
            case 0:
                return betTable.doBetTypeHRedBlack(RouletteColorsEnum.RED,
                        RouletteBetTypesEnum.TYPE_H.getMinAmount(),
                        this);
            case 1:
                return betTable.doBetTypeHRedBlack(RouletteColorsEnum.BLACK,
                        RouletteBetTypesEnum.TYPE_H.getMinAmount(),
                        this);
            default:
                System.out.println("!!! Error out of range");
                return false;
        }
    }

    @Override
    void notification(RouletteSector sector, int winAmount) {
        System.out.println("OK, got " + winAmount + " " + sector);
    }
}
