package games.roulette.enums;

import games.roulette.IntegerGetable;

public enum RouletteTwelvesEnum implements IntegerGetable {

    FIRST_12(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}),
    SECOND_12(new int[]{13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}),
    THIRD_12(new int[]{25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36});

    private int[] numbers;

    RouletteTwelvesEnum(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public int[] getNumbers() {
        return numbers;
    }

}
