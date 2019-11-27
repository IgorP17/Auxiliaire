package games.roulette;

public abstract class Strategy {

    abstract boolean bet(RouletteBetTable betTable);

    abstract void notification(RouletteSector sector, int winAmount);

}
