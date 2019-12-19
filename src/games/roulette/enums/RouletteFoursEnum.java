package games.roulette.enums;

import games.roulette.IntegerGetable;

public enum RouletteFoursEnum implements IntegerGetable {

    FOURS_1_2_4_5(new int[]{1, 2, 4, 5}),
    FOURS_2_3_5_6(new int[]{2, 3, 5, 6}),
    FOURS_4_5_7_8(new int[]{4, 5, 7, 8}),
    FOURS_5_6_8_9(new int[]{5, 6, 8, 9}),
    FOURS_7_8_10_11(new int[]{7, 8, 10, 11}),
    FOURS_8_9_11_12(new int[]{8, 9, 11, 12}),
    FOURS_10_11_13_14(new int[]{10, 11, 13, 14}),
    FOURS_11_12_14_15(new int[]{11, 12, 14, 15}),
    FOURS_13_14_16_17(new int[]{13, 14, 16, 17}),
    FOURS_14_15_17_18(new int[]{14, 15, 17, 18}),
    FOURS_16_17_19_20(new int[]{16, 17, 19, 20}),
    FOURS_17_18_20_21(new int[]{17, 18, 20, 21}),
    FOURS_19_20_22_23(new int[]{19, 20, 22, 23}),
    FOURS_20_21_23_24(new int[]{20, 21, 23, 24}),
    FOURS_22_23_25_26(new int[]{22, 23, 25, 26}),
    FOURS_23_24_26_27(new int[]{23, 24, 26, 27}),
    FOURS_25_26_28_29(new int[]{25, 26, 28, 29}),
    FOURS_26_27_29_30(new int[]{26, 27, 29, 30}),
    FOURS_28_29_31_32(new int[]{28, 29, 31, 32}),
    FOURS_29_30_32_33(new int[]{29, 30, 32, 33}),
    FOURS_31_32_34_35(new int[]{31, 32, 34, 35}),
    FOURS_32_33_35_36(new int[]{32, 33, 35, 36});

    private int[] numbers;

    RouletteFoursEnum(int[] numbers) {
        this.numbers = numbers;
    }

    // getters
    @Override
    public int[] getNumbers() {
        return numbers;
    }
}
