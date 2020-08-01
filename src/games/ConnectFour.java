package games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConnectFour {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<String>(Arrays.asList(
                "A_Red",
                "B_Yellow",
                "A_Red",
                "B_Yellow",
                "A_Red",
                "B_Yellow",
                "G_Red",
                "B_Yellow"
        ));

        System.out.println(whoIsWinner(myList) + " == Yellow");

        myList = new ArrayList<String>(Arrays.asList(
                "C_Yellow",
                "E_Red",
                "G_Yellow",
                "B_Red",
                "D_Yellow",
                "B_Red",
                "B_Yellow",
                "G_Red",
                "C_Yellow",
                "C_Red",
                "D_Yellow",
                "F_Red",
                "E_Yellow",
                "A_Red",
                "A_Yellow",
                "G_Red",
                "A_Yellow",
                "F_Red",
                "F_Yellow",
                "D_Red",
                "B_Yellow",
                "E_Red",
                "D_Yellow",
                "A_Red",
                "G_Yellow",
                "D_Red",
                "D_Yellow",
                "C_Red"
        ));

        System.out.println(whoIsWinner(myList) + " == Yellow");

        myList = new ArrayList<String>(Arrays.asList(
                "A_Yellow",
                "B_Red",
                "B_Yellow",
                "C_Red",
                "G_Yellow",
                "C_Red",
                "C_Yellow",
                "D_Red",
                "G_Yellow",
                "D_Red",
                "G_Yellow",
                "D_Red",
                "F_Yellow",
                "E_Red",
                "D_Yellow"
        ));

        System.out.println(whoIsWinner(myList) + " == Red");

    }

    public static String whoIsWinner(List<String> piecesPositionList) {
        // retrun "Red" or "Yellow" or "Draw"
        Board board = new Board(piecesPositionList);
        board.printBoard();
        return board.doCheck();
    }

}

class Board {
    private final String[][] board = new String[6][7];
    private final int[] boardIDX = new int[]{5, 5, 5, 5, 5, 5, 5};

    Board(List<String> piecesPositionList) {
        String cell;
        String color;
        for (String move : piecesPositionList) {
            cell = move.split("_")[0];
            color = move.split("_")[1].substring(0, 1);
            doMove(cell, color);
        }
        doCheck();
    }

    // do move
    private void doMove(String cell, String color) {
        switch (cell) {
            case "A":
                board[boardIDX[0]][0] = color;
                boardIDX[0]--;
                break;
            case "B":
                board[boardIDX[1]][1] = color;
                boardIDX[1]--;
                break;
            case "C":
                board[boardIDX[2]][2] = color;
                boardIDX[2]--;
                break;
            case "D":
                board[boardIDX[3]][3] = color;
                boardIDX[3]--;
                break;
            case "E":
                board[boardIDX[4]][4] = color;
                boardIDX[4]--;
                break;
            case "F":
                board[boardIDX[5]][5] = color;
                boardIDX[5]--;
                break;
            case "G":
                board[boardIDX[6]][6] = color;
                boardIDX[6]--;
                break;
        }
    }

    // check
    String doCheck() {
        // rows
        int start = 0;
        for (int i = 0; i < board.length; i++) {
            while (start < 3) {
                if (board[i][start] != null) {
                    if (board[i][start].equalsIgnoreCase(board[i][start + 1])
                            && board[i][start].equalsIgnoreCase(board[i][start + 2])
                            && board[i][start].equalsIgnoreCase(board[i][start + 3])){
                        return board[i][start];
                    }
                }
                start++;
            }
        }
        // cols

        // diag
        return null;
    }

    // print board
    void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] == null ? "." : board[i][j]);
                if (j != board[0].length - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
