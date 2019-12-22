package games.roulette.enums;

import games.roulette.IntegerGetable;

public enum RouletteEvenOddEnum implements IntegerGetable {


    ODD(new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35}),
    EVEN(new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36});

    private int[] numbers;

    RouletteEvenOddEnum(int[] numbers) {
        this.numbers = numbers;
    }

    // getters
    @Override
    public int[] getNumbers() {
        return numbers;
    }
}
