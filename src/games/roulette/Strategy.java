package games.roulette;

abstract class Strategy {

    protected int total;
    private int winCount = 0;

    Strategy(int total){
        this.total = total;
    }

    boolean makeBet(RouletteBetTable betTable){
        if (total <= 0){
            return false;
        }
        total = total - bet(betTable);
        return true;
    }

    // override me
    abstract int bet(RouletteBetTable betTable);

    // override me
    void notification(RouletteSector sector, int winAmount) {
        System.out.println("OK, got " + winAmount + " " + sector);
        total = total + winAmount;
        winCount++;
    }

    // getters

    int getTotal() {
        return total;
    }

    int getWinCount() {
        return winCount;
    }

    @Override
    public String toString() {
        return "Strategy{" +
                "total=" + total +
                ", winCount=" + winCount +
                '}';
    }
}
