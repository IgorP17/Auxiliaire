package hyperskill.minesweeper;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many mines do you want on the field? ");

        int numOfBombs = Integer.parseInt(scanner.nextLine());
        Field field = new Field(9, 9, numOfBombs);
        field.printState();
    }

}

class Field {
    private int x;
    private int y;
    private int numOfBombs;

    private String[][] field;

    Field(int x, int y, int numOfBombs){
        this.x = x;
        this.y = y;
        this.numOfBombs = numOfBombs;
        field = new String[x][y];
        generateField();
    }

    /**
     * . save field
     * X bomb
     */
    private void generateField(){
        if (numOfBombs > x * y || numOfBombs < 0){
            throw new RuntimeException("Illegal num of bombs!");
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                field[i][j] = ".";
            }
        }
        int xRnd;
        int yRnd;
        Random xRandom = new Random();
        Random yRandom = new Random();
        int genCount = 0;
        while (genCount < numOfBombs){
            xRnd = xRandom.nextInt(x);
            yRnd = yRandom.nextInt(y);
            // check if field is save and we can place bomb
            if (".".equalsIgnoreCase(field[xRnd][yRnd])){
                field[xRnd][yRnd] = "X";
                genCount++;
            }
        }
    }

    void printState(){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

}