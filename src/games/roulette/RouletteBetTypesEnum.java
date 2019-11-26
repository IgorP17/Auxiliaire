package games.roulette;

public enum RouletteBetTypesEnum {

    TYPE_A(35, 100, 1000), // direct bet
    TYPE_B(0, 0, 0),
    TYPE_C(0, 0, 0),
    TYPE_D(0, 0, 0),
    TYPE_E(0, 0, 0),
    TYPE_F(0, 0, 0),
    TYPE_G(0, 0, 0),
    TYPE_H(1, 100, 10000);

    private int payRoll;
    private int minAmount;
    private int maxAmount;

    RouletteBetTypesEnum(int payRoll, int minAmount, int maxAmount) {
        this.payRoll = payRoll;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    // getters
    int getPayRoll() {
        return payRoll;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public int getMaxAmount() {
        return maxAmount;
    }
}
