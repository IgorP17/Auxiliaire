package games.tictactoe;

import java.util.ArrayList;

public class HardLevel {

    private static String huPlayer = "O";
    private static String aiPlayer = "X";

    // this is the board flattened and filled with some values to easier asses the Artificial Inteligence.
//    private static String[] origBoard = new String[]{"O", "1", "X", "X", "4", "X", "6", "O", "O"};
//    private static String[] origBoard = new String[]{"O", "1", "X", " ", "X", "X", "6", "O", "O"};
    private static String[] origBoard = new String[]{" ", "O", "X",
                                                     " ", "X", " ",
                                                     "O", " ", " "};
    //keeps count of function calls
    private static int fc = 0;

    public static String getMove(String[] board, String huPlayer1, String aiPlayer1){
        origBoard = board;
        huPlayer = huPlayer1;
        aiPlayer = aiPlayer1;
        return minimax(origBoard, aiPlayer).getIndex();
    }


    public static void main(String[] args) {
        Move move = minimax(origBoard, aiPlayer);
        System.out.println("Move at " + move.getIndex() + "; func calls = " + fc);
    }

    private static Move minimax(String[] newBoard, String player) {
        //add one to function calls
        fc++;
//        System.out.println("Function call = " + fc);
        //available spots
        ArrayList<Integer> availSpots = emptyIndexies(newBoard);
//        System.out.println("Available spots = " + availSpots.toString());


        // an array to collect all the objects
        ArrayList<Move> moves = new ArrayList<>();

        // loop through available spots
        for (var i = 0; i < availSpots.size(); i++) {
            //create an object for each and store the index of that spot that was stored as a number in the object's index key
            Move move = new Move(null, -1);
            move.setIndex(newBoard[availSpots.get(i)]);

            // set the empty spot to the current player
            newBoard[availSpots.get(i)] = player;

            // checks for the terminal states such as win, lose, and tie and returning a value accordingly
            if (winning(newBoard, huPlayer)) {
                return new Move(availSpots.get(i).toString(), -10);
            } else if (winning(newBoard, aiPlayer)) {
                return new Move(availSpots.get(i).toString(), 10);
                // TODO?????
            } else if (availSpots.size() == 1) {
                return new Move(availSpots.get(i).toString(), 0);
            }

            //if collect the score resulted from calling minimax on the opponent of the current player
            Move result;
            if (player.equals(aiPlayer)) {
                result = minimax(newBoard, huPlayer);
                move.setScore(result.getScore());
            } else {
                result = minimax(newBoard, aiPlayer);
                move.setScore(result.getScore());
            }

            //reset the spot to empty
            newBoard[availSpots.get(i)] = " ";

            // push the object to the array
            moves.add(move);
        }

        // if it is the computer's turn loop over the moves and choose the move with the highest score
        int bestMove = 0;
        if (player.equals(aiPlayer)) {
            int bestScore = -10000;
            for (var i = 0; i < moves.size(); i++) {
                if (moves.get(i).getScore() > bestScore) {
                    bestScore = moves.get(i).getScore();
                    bestMove = i;
                }
            }
        } else {

            // else loop over the moves and choose the move with the lowest score
            int bestScore = 10000;
            for (var i = 0; i < moves.size(); i++) {
                if (moves.get(i).getScore() < bestScore) {
                    bestScore = moves.get(i).getScore();
                    bestMove = i;
                }
            }
        }

        // return the chosen move (object) from the array to the higher depth
        return moves.get(bestMove);
    }


    // returns the available spots on the board
    private static ArrayList<Integer> emptyIndexies(String[] board) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            if (!board[i].equalsIgnoreCase("X") &&
                    !board[i].equalsIgnoreCase("O")) {
                result.add(i);
//                System.out.println("Board i = " + board[i]);
            }
        }
        return result;
    }

    // check winner
    private static boolean winning(String[] board, String player) {
        if (
                (board[0].equals(player) && board[1].equals(player) && board[2].equals(player)) ||
                        (board[3].equals(player) && board[4].equals(player) && board[5].equals(player)) ||
                        (board[6].equals(player) && board[7].equals(player) && board[8].equals(player)) ||
                        (board[0].equals(player) && board[3].equals(player) && board[6].equals(player)) ||
                        (board[1].equals(player) && board[4].equals(player) && board[7].equals(player)) ||
                        (board[2].equals(player) && board[5].equals(player) && board[8].equals(player)) ||
                        (board[0].equals(player) && board[4].equals(player) && board[8].equals(player)) ||
                        (board[2].equals(player) && board[4].equals(player) && board[6].equals(player))
        ) {
            return true;
        } else {
            return false;
        }
    }
}

class Move {
    private String index;
    private Integer score;


    public Integer getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Move(String index, int score) {
        this.index = index;
        this.score = score;
    }
}
