package games.roulette.enums;

import games.roulette.IntegerGetable;

public enum RouletteRowEnum implements IntegerGetable {

    FIRST_LINE(new int[]{1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34}),
    SECOND_LINE(new int[]{2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35}),
    THIRD_LINE(new int[]{3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36});

    private int[] numbers;

    RouletteRowEnum(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public int[] getNumbers() {
        return numbers;
    }

}
