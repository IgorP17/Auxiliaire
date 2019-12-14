package games.roulette;

public enum RouletteTriplesEnum {

    TRIPLE_1_2_3(1, 2, 3),
    TRIPLE_4_5_6(4, 5, 6),
    TRIPLE_7_8_9(7, 8, 9),
    TRIPLE_10_11_12(10, 11, 12),
    TRIPLE_13_14_15(13, 14, 15),
    TRIPLE_16_17_18(16, 17, 18),
    TRIPLE_19_20_21(19, 20, 21),
    TRIPLE_22_23_24(22, 23, 24),
    TRIPLE_25_26_27(25, 26, 27),
    TRIPLE_28_29_30(28, 29, 30),
    TRIPLE_31_32_33(31, 32, 33),
    TRIPLE_34_35_36(34, 35, 36),
    TRIPLE_0_1_2(0, 1, 2),
    TRIPLE_0_2_3(0, 2, 3);


    private int a;
    private int b;
    private int c;

    RouletteTriplesEnum(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // getters

    int getA() {
        return a;
    }

    int getB() {
        return b;
    }

    int getC() {
        return c;
    }
}
