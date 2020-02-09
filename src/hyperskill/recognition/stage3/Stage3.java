package hyperskill.recognition.stage3;

import java.util.Scanner;

public class Stage3 {
    // in layer 15
    private static int[] inLayer = new int[15];
    // out layer
    private static int[] outLayer = new int[10];
    // w - blue +1 white -1
    private final static int[][] w = new int[][]{
            {+1, +1, +1, +1, -1, +1, +1, -1, +1, +1, -1, +1, +1, +1, +1},//0
            {-1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1, -1},//1
            {+1, +1, +1, -1, -1, +1, +1, +1, +1, +1, -1, -1, +1, +1, +1},//2
            {+1, +1, +1, -1, -1, +1, +1, +1, +1, -1, -1, +1, +1, +1, +1},//3
            {+1, -1, +1, +1, -1, +1, +1, +1, +1, -1, -1, +1, -1, -1, +1},//4
            {+1, +1, +1, +1, -1, -1, +1, +1, +1, -1, -1, +1, +1, +1, +1},//5
            {+1, +1, +1, +1, -1, -1, +1, +1, +1, +1, -1, +1, +1, +1, +1},//6
            {+1, +1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1},//7
            {+1, +1, +1, +1, -1, +1, +1, +1, +1, +1, -1, +1, +1, +1, +1},//8
            {+1, +1, +1, +1, -1, +1, +1, +1, +1, -1, -1, +1, +1, +1, +1}//9
    };
    // bias
    private final static int[] b = new int[]{-1, 6, 0, 0, 2, 0, -1, 4, -2, -1};

    public static void main(String[] args) {

        while(true){
            System.out.println("1. Learn the network");
            System.out.println("2. Guess a number");
            System.out.println("0. Exit");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 0){
                break;
            }
            switch (choice){
                case 1:
                    learn();
                    break;
                case 2:
                    guess();
                    break;

            }
        }
    }

    /**
     * guess number
     */
    private static void guess() {
        readInput();
        calcOutLayer();
    }

    /**
     * learn
     */
    private static void learn() {
    }

    /**
     * read input
     */
    private static void readInput() {
        // 5 lines
        Scanner scanner = new Scanner(System.in);
        String str;
        for (int i = 0; i < 15; i = i + 3) {
            str = scanner.nextLine();
            inLayer[i] = getInput(str.charAt(0));
            inLayer[i + 1] = getInput(str.charAt(1));
            inLayer[i + 2] = getInput(str.charAt(2));
        }
    }

    private static int getInput(char ch) {
        if ('X' == ch) {
            return 1;
        }
        return 0;
    }

    /**
     * Calc out
     */
    private static void calcOutLayer() {
    /*
    outLayer[0] = inLayer[0] * w[0][0]
            + inLayer[1] * w[0][1]
            + inLayer[2] * w[0][2]
            ...
            + b[0];
     */
        for (int i = 0; i < outLayer.length; i++) {
            outLayer[i] = inLayer[0] * w[i][0]
                    + inLayer[1] * w[i][1]
                    + inLayer[2] * w[i][2]
                    + inLayer[3] * w[i][3]
                    + inLayer[4] * w[i][4]
                    + inLayer[5] * w[i][5]
                    + inLayer[6] * w[i][6]
                    + inLayer[7] * w[i][7]
                    + inLayer[8] * w[i][8]
                    + inLayer[9] * w[i][9]
                    + inLayer[10] * w[i][10]
                    + inLayer[11] * w[i][11]
                    + inLayer[12] * w[i][12]
                    + inLayer[13] * w[i][13]
                    + inLayer[14] * w[i][14]
                    + b[i];
        }
    }
}
