package games.roulette.strategy;

import games.roulette.RouletteBetTable;
import games.roulette.RouletteSector;
import games.roulette.enums.RouletteBetTypesEnum;
import games.roulette.enums.RouletteTwelvesEnum;

public class FirstTwoTwelvesStrategy extends Strategy {

    private int bet = RouletteBetTypesEnum.TYPE_G.getMinAmount();

    public FirstTwoTwelvesStrategy(int total) {
        super(total);
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

        // do a bet on first 12
        result = betTable.doBet(
                RouletteBetTypesEnum.TYPE_G,
                RouletteTwelvesEnum.FIRST_12,
                bet,
                this);
        if (!result)
            return false;
        // do a bet on second 12
        result = betTable.doBet(
                RouletteBetTypesEnum.TYPE_G,
                RouletteTwelvesEnum.SECOND_12,
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
        // if we loose double bet
        // NOT (first 2 twelves) or zero
        if (winSector.getNumber() > 24 ||
                winSector.getNumber() == 0) {
            // not exceed max
            if (2 * bet <= RouletteBetTypesEnum.TYPE_G.getMaxAmount()) {
                bet = 2 * bet;
                System.out.println(this.getClass().getSimpleName() + ": Double, now bet is = " + bet);
            } else {
                System.out.println(this.getClass().getSimpleName() + ": Cant Double, now bet is = " + bet);
            }
        } else {
            // we won
            // Check balance and fallback to min in case balance > 0
            if (getBalance() > 0) {
                bet = RouletteBetTypesEnum.TYPE_G.getMinAmount();
                System.out.println(this.getClass().getSimpleName() + ": Fallback, now bet is = " + bet);
            }
        }
    }
}
