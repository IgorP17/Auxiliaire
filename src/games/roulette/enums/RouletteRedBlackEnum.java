package games.roulette.enums;

import games.roulette.IntegerGetable;

public enum RouletteRedBlackEnum implements IntegerGetable {


    RED(new int[]{
            1,
            3,
            5,
            7,
            9,
            12,
            14,
            16,
            18,
            19,
            21,
            23,
            25,
            27,
            30,
            32,
            34,
            36,}),
    BLACK(new int[]{
            2,
            4,
            6,
            8,
            10,
            11,
            13,
            15,
            17,
            20,
            22,
            24,
            26,
            28,
            29,
            31,
            33,
            35,
    });

    private int[] numbers;

    RouletteRedBlackEnum(int[] numbers) {
        this.numbers = numbers;
    }

    // getters
    @Override
    public int[] getNumbers() {
        return numbers;
    }
}
