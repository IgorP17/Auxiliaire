package games.roulette.enums;

import games.roulette.IntegerGetable;

public enum RouletteSixEnum implements IntegerGetable {

    SIX_1_2_3_4_5_6(new int[]{1, 2, 3, 4, 5, 6}),
    SIX_4_5_6_7_8_9(new int[]{4, 5, 6, 7, 8, 9}),
    SIX_7_8_9_10_11_12(new int[]{7, 8, 9, 10, 11, 12}),
    SIX_10_11_12_13_14_15(new int[]{10, 11, 12, 13, 14, 15}),
    SIX_13_14_15_16_17_18(new int[]{13, 14, 15, 16, 17, 18}),
    SIX_16_17_18_19_20_21(new int[]{16, 17, 18, 19, 20, 21}),
    SIX_19_20_21_22_23_24(new int[]{19, 20, 21, 22, 23, 24}),
    SIX_22_23_24_25_26_27(new int[]{22, 23, 24, 25, 26, 27}),
    SIX_25_26_27_28_29_30(new int[]{25, 26, 27, 28, 29, 30}),
    SIX_28_29_30_31_32_33(new int[]{28, 29, 30, 31, 32, 33}),
    SIX_31_32_33_34_35_36(new int[]{31, 32, 33, 34, 35, 36});

    private int[] numbers;

    RouletteSixEnum(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public int[] getNumbers() {
        return numbers;
    }

}
