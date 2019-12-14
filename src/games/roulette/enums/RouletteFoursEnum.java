package games.roulette.enums;

public enum RouletteFoursEnum {

    FOURS_1_2_4_5(1, 2, 4, 5),
    FOURS_2_3_5_6(2, 3, 5, 6),
    FOURS_4_5_7_8(4, 5, 7, 8),
    FOURS_5_6_8_9(5, 6, 8, 9),
    FOURS_7_8_10_11(7, 8, 10, 11),
    FOURS_8_9_11_12(8, 9, 11, 12),
    FOURS_10_11_13_14(10, 11, 13, 14),
    FOURS_11_12_14_15(11, 12, 14, 15),
    FOURS_13_14_16_17(13, 14, 16, 17),
    FOURS_14_15_17_18(14, 15, 17, 18),
    FOURS_16_17_19_20(16, 17, 19, 20),
    FOURS_17_18_20_21(17, 18, 20, 21),
    FOURS_19_20_22_23(19, 20, 22, 23),
    FOURS_20_21_23_24(20, 21, 23, 24),
    FOURS_22_23_25_26(22, 23, 25, 26),
    FOURS_23_24_26_27(23, 24, 26, 27),
    FOURS_25_26_28_29(25, 26, 28, 29),
    FOURS_26_27_29_30(26, 27, 29, 30),
    FOURS_28_29_31_32(28, 29, 31, 32),
    FOURS_29_30_32_33(29, 30, 32, 33),
    FOURS_31_32_34_35(31, 32, 34, 35),
    FOURS_32_33_35_36(32, 33, 35, 36);

    private int a;
    private int b;
    private int c;
    private int d;

    RouletteFoursEnum(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    // getters

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }
}
