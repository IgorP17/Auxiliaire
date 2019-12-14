package games.roulette;

import games.roulette.strategy.Strategy;

class RouletteBetItem {

    private RouletteSector rouletteSector;
    private RouletteBetTypesEnum rouletteBetTypesEnum;
    private int betAmount;
    private int winAmount;
    private Strategy strategy;

    RouletteBetItem(RouletteSector rouletteSector,
                    RouletteBetTypesEnum rouletteBetTypesEnum,
                    int betAmoun,
                    int winAmount,
                    Strategy strategy) {
        this.rouletteSector = rouletteSector;
        this.rouletteBetTypesEnum = rouletteBetTypesEnum;
        this.betAmount = betAmoun;
        this.winAmount = winAmount;
        this.strategy = strategy;
    }

    // getters

    RouletteSector getRouletteSector() {
        return rouletteSector;
    }

    int getWinAmount() {
        return winAmount;
    }

    Strategy getStrategy() {
        return strategy;
    }

    @Override
    public String toString() {
        return "RouletteBetItem{" +
                "rouletteSector=" + rouletteSector +
                ", rouletteBetTypesEnum=" + rouletteBetTypesEnum +
                ", betAmount=" + betAmount +
                ", winAmount=" + winAmount +
                ", strategy=" + strategy.getClass().getSimpleName() +
                '}';
    }
}
