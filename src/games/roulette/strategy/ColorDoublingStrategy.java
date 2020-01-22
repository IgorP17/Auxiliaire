package games.roulette.strategy;

import games.roulette.RouletteBetTable;
import games.roulette.RouletteSector;
import games.roulette.enums.RouletteBetTypesEnum;
import games.roulette.enums.RouletteRedBlackEnum;

public class ColorDoublingStrategy extends Strategy {

    private static RouletteBetTypesEnum betType = RouletteBetTypesEnum.TYPE_H;
    private int bet = betType.getMinAmount();
    private RouletteRedBlackEnum betON = RouletteRedBlackEnum.RED;
    private static int maxBet;

    public ColorDoublingStrategy(int total) {
        super(total);
    }

    static {
        int maxBet = betType.getMinAmount();
        int max = betType.getMaxAmount();
        while (maxBet * 4 < max) {
            maxBet = maxBet * 2;
        }
        System.out.println(ColorDoublingStrategy.class.getSimpleName() + ": bet before max = " + maxBet);
    }

    /**
     * Do a bets on 2 twelves
     *
     * @param betTable - bet table
     * @return - true if all bets set up
     */
    @Override
    boolean bet(RouletteBetTable betTable) {
        boolean result;
        // TODO Do not bet...if
        result = betTable.doBet(
                betType,
                betON,
                bet,
                this);
        return result;
    }

    /**
     * x2 bets in case we have loose
     *
     * @param winSector - win sector
     */
    @Override
    public void notification(RouletteSector winSector) {
        super.notification(winSector);
        boolean win = false;
        for (int i:
             betON.getNumbers()) {
            if (i == winSector.getNumber()){
                win = true;
                break;
            }
        }
        // if we loose double bet
        if (!win){
            if (2 * bet <= betType.getMaxAmount()){
                bet = 2 * bet;
                System.out.println(this.getClass().getSimpleName() + ": Double, now bet is = " + bet);
            } else {
                System.out.println(this.getClass().getSimpleName() + ": Cant Double, now bet is = " + bet);
            }
        }


    }
}
