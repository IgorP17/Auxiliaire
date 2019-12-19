package games.roulette.enums;

import games.roulette.IntegerGetable;

public enum RouletteTriplesEnum implements IntegerGetable {

    TRIPLE_1_2_3(new int[]{1, 2, 3}),
    TRIPLE_4_5_6(new int[]{4, 5, 6}),
    TRIPLE_7_8_9(new int[]{7, 8, 9}),
    TRIPLE_10_11_12(new int[]{10, 11, 12}),
    TRIPLE_13_14_15(new int[]{13, 14, 15}),
    TRIPLE_16_17_18(new int[]{16, 17, 18}),
    TRIPLE_19_20_21(new int[]{19, 20, 21}),
    TRIPLE_22_23_24(new int[]{22, 23, 24}),
    TRIPLE_25_26_27(new int[]{25, 26, 27}),
    TRIPLE_28_29_30(new int[]{28, 29, 30}),
    TRIPLE_31_32_33(new int[]{31, 32, 33}),
    TRIPLE_34_35_36(new int[]{34, 35, 36}),
    TRIPLE_0_1_2(new int[]{0, 1, 2}),
    TRIPLE_0_2_3(new int[]{0, 2, 3});


    private int[] numbers;

    RouletteTriplesEnum(int[] numbers) {
        this.numbers = numbers;
    }

    // getters
    @Override
    public int[] getNumbers() {
        return numbers;
    }
}
