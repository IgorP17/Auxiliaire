package games.roulette.enums;

import games.roulette.IntegerGetable;

public enum RoulettePairsEnum implements IntegerGetable {

    PAIR_1_2(new int[]{1, 2}),
    PAIR_1_4(new int[]{1, 4}),
    PAIR_2_3(new int[]{2, 3}),
    PAIR_2_5(new int[]{2, 5}),
    PAIR_3_6(new int[]{3, 6}),
    PAIR_4_5(new int[]{4, 5}),
    PAIR_4_7(new int[]{4, 7}),
    PAIR_5_6(new int[]{5, 6}),
    PAIR_5_8(new int[]{5, 8}),
    PAIR_6_9(new int[]{6, 9}),
    PAIR_7_8(new int[]{7, 8}),
    PAIR_7_10(new int[]{7, 10}),
    PAIR_8_9(new int[]{8, 9}),
    PAIR_8_11(new int[]{8, 11}),
    PAIR_9_12(new int[]{9, 12}),
    PAIR_10_11(new int[]{10, 11}),
    PAIR_10_13(new int[]{10, 13}),
    PAIR_11_12(new int[]{11, 12}),
    PAIR_11_14(new int[]{11, 14}),
    PAIR_12_15(new int[]{12, 15}),
    PAIR_13_14(new int[]{13, 14}),
    PAIR_13_16(new int[]{13, 16}),
    PAIR_14_15(new int[]{14, 15}),
    PAIR_14_17(new int[]{14, 17}),
    PAIR_15_18(new int[]{15, 18}),
    PAIR_16_17(new int[]{16, 17}),
    PAIR_16_19(new int[]{16, 19}),
    PAIR_17_18(new int[]{17, 18}),
    PAIR_17_20(new int[]{17, 20}),
    PAIR_18_21(new int[]{18, 21}),
    PAIR_19_20(new int[]{19, 20}),
    PAIR_19_22(new int[]{19, 22}),
    PAIR_20_21(new int[]{20, 21}),
    PAIR_20_23(new int[]{20, 23}),
    PAIR_21_24(new int[]{21, 24}),
    PAIR_22_23(new int[]{22, 23}),
    PAIR_22_25(new int[]{22, 25}),
    PAIR_23_24(new int[]{23, 24}),
    PAIR_23_26(new int[]{23, 26}),
    PAIR_24_27(new int[]{24, 27}),
    PAIR_25_26(new int[]{25, 26}),
    PAIR_25_28(new int[]{25, 28}),
    PAIR_26_27(new int[]{26, 27}),
    PAIR_26_29(new int[]{26, 29}),
    PAIR_27_30(new int[]{27, 30}),
    PAIR_28_29(new int[]{28, 29}),
    PAIR_28_31(new int[]{28, 31}),
    PAIR_29_30(new int[]{29, 30}),
    PAIR_29_32(new int[]{29, 32}),
    PAIR_30_33(new int[]{30, 33}),
    PAIR_31_32(new int[]{31, 32}),
    PAIR_31_34(new int[]{31, 34}),
    PAIR_32_33(new int[]{32, 33}),
    PAIR_32_35(new int[]{32, 35}),
    PAIR_33_36(new int[]{33, 36}),
    PAIR_34_35(new int[]{34, 35}),
    PAIR_35_36(new int[]{35, 36});

    private int[] numbers;

    RoulettePairsEnum(int[] numbers) {
        this.numbers = numbers;
    }

    // getters
    @Override
    public int[] getNumbers() {
        return numbers;
    }


}
