package games.roulette.strategy;

import games.roulette.RouletteBetTable;
import games.roulette.RouletteSector;

public abstract class Strategy {

    int total;
    int betAmount;
    private int winCount = 0;
    private int initialSum;

    Strategy(int total) {
        this.total = total;
        this.initialSum = total;
    }

    public boolean makeBet(RouletteBetTable betTable) {
        if (total <= 0) {
            return false;
        }
        // this should init/change betAmount
        boolean result = bet(betTable);
        total = total - betAmount;
        return result;
    }

    // override me
    abstract boolean bet(RouletteBetTable betTable);

    /**
     * Receive wins
     *
     * @param winAmount - amount
     */
    public void notification(int winAmount) {
        System.out.println(this.getClass().getSimpleName() + ": OK, got " + winAmount);
        total = total + winAmount;
        winCount++;
    }

    /**
     * Receive win sector
     * This can be override to save history
     *
     * @param winSector - win sector
     */
    public void notification(RouletteSector winSector) {
        System.out.println(this.getClass().getSimpleName() + ": OK, got " + winSector);
    }

    @Override
    public String toString() {
        return "Strategy{name=" +
                this.getClass().getSimpleName() +
                ", total=" + total +
                ", winCount=" + winCount +
                ", balance=" + (total - initialSum) +
                '}';
    }

    int getBalance() {
        return total - initialSum;
    }
}