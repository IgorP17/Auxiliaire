package games.roulette;

import java.util.Comparator;

abstract class Strategy {

    protected int total;
    protected int betAmount;
    private int winCount = 0;
    private int initialSum;

    Strategy(int total) {
        this.total = total;
        this.initialSum = total;
    }

    boolean makeBet(RouletteBetTable betTable) {
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
    void notification(int winAmount) {
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
    void notification(RouletteSector winSector) {
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

    int getBalance(){
        return total - initialSum;
    }
}

/**
 * Compare strategies - use balance
 */
class StrategyComparator implements Comparator<Strategy>{

    @Override
    public int compare(Strategy o1, Strategy o2) {
        System.out.println("S1:");
        System.out.println(o1);
        System.out.println("S2:");
        System.out.println(o2);
        int compare = Integer.compare(o1.getBalance(), o2.getBalance());
        System.out.println(compare);
        return compare;
    }
}