package games.roulette.enums;

import games.roulette.IntegerGetable;

public enum RouletteHalfEnum implements IntegerGetable {


    FIRST_HALF(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}),
    SECOND_HALF(new int[]{19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36});

    private int[] numbers;

    RouletteHalfEnum(int[] numbers) {
        this.numbers = numbers;
    }

    // getters
    @Override
    public int[] getNumbers() {
        return numbers;
    }
}
