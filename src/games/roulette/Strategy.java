package games.roulette;

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
}
