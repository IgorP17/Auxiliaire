package games.roulette;

public class RouletteBetItem {

    private RouletteSector rouletteSector;
    private RouletteBetTypesEnum rouletteBetTypesEnum;
    private int betAmount;
    private int winAmount;
    private String className;

    RouletteBetItem(RouletteSector rouletteSector,
                    RouletteBetTypesEnum rouletteBetTypesEnum,
                    int betAmoun,
                    int winAmount,
                    String className){
        this.rouletteSector = rouletteSector;
        this.rouletteBetTypesEnum = rouletteBetTypesEnum;
        this.betAmount = betAmoun;
        this.winAmount = winAmount;
        this.className = className;
    }





    // compare
    boolean compare(RouletteSector sector){
        return rouletteSector.equals(sector);
    }

    // getters

    public RouletteSector getRouletteSector() {
        return rouletteSector;
    }

    public RouletteBetTypesEnum getRouletteBetTypesEnum() {
        return rouletteBetTypesEnum;
    }

    public int getBetAmount() {
        return betAmount;
    }

    public int getWinAmount() {
        return winAmount;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "RouletteBetItem{" +
                "rouletteSector=" + rouletteSector +
                ", rouletteBetTypesEnum=" + rouletteBetTypesEnum +
                ", betAmount=" + betAmount +
                ", winAmount=" + winAmount +
                ", className='" + className + '\'' +
                '}';
    }
}
