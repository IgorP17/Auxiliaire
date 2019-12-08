package games.roulette;

enum RouletteBetTypesEnum {

    TYPE_A(35, 100, 1000), // direct bet
    TYPE_B(17, 100, 2000), // pairs
    TYPE_C(11, 100, 0),
    TYPE_D(8, 100, 0),
    TYPE_E(5, 100, 0),
    TYPE_F(2, 100, 0),
    TYPE_G(2, 100, 0),
    TYPE_H(1, 100, 10000); //

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
