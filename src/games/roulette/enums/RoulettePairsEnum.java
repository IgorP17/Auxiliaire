package games.roulette.enums;

public enum RoulettePairsEnum {

    PAIR_1_2(1, 2),
    PAIR_1_4(1, 4),
    PAIR_2_3(2, 3),
    PAIR_2_5(2, 5),
    PAIR_3_6(3, 6),
    PAIR_4_5(4, 5),
    PAIR_4_7(4, 7),
    PAIR_5_6(5, 6),
    PAIR_5_8(5, 8),
    PAIR_6_9(6, 9),
    PAIR_7_8(7, 8),
    PAIR_7_10(7, 10),
    PAIR_8_9(8, 9),
    PAIR_8_11(8, 11),
    PAIR_9_12(9, 12),
    PAIR_10_11(10, 11),
    PAIR_10_13(10, 13),
    PAIR_11_12(11, 12),
    PAIR_11_14(11, 14),
    PAIR_12_15(12, 15),
    PAIR_13_14(13, 14),
    PAIR_13_16(13, 16),
    PAIR_14_15(14, 15),
    PAIR_14_17(14, 17),
    PAIR_15_18(15, 18),
    PAIR_16_17(16, 17),
    PAIR_16_19(16, 19),
    PAIR_17_18(17, 18),
    PAIR_17_20(17, 20),
    PAIR_18_21(18, 21),
    PAIR_19_20(19, 20),
    PAIR_19_22(19, 22),
    PAIR_20_21(20, 21),
    PAIR_20_23(20, 23),
    PAIR_21_24(21, 24),
    PAIR_22_23(22, 23),
    PAIR_22_25(22, 25),
    PAIR_23_24(23, 24),
    PAIR_23_26(23, 26),
    PAIR_24_27(24, 27),
    PAIR_25_26(25, 26),
    PAIR_25_28(25, 28),
    PAIR_26_27(26, 27),
    PAIR_26_29(26, 29),
    PAIR_27_30(27, 30),
    PAIR_28_29(28, 29),
    PAIR_28_31(28, 31),
    PAIR_29_30(29, 30),
    PAIR_29_32(29, 32),
    PAIR_30_33(30, 33),
    PAIR_31_32(31, 32),
    PAIR_31_34(31, 34),
    PAIR_32_33(32, 33),
    PAIR_32_35(32, 35),
    PAIR_33_36(33, 36),
    PAIR_34_35(34, 35),
    PAIR_35_36(35, 36);

    private int a;
    private int b;

    RoulettePairsEnum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    // getters

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
