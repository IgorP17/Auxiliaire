package hyperskill.linearequationssolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Gaussian elimination
 * Gauss - Jordan elimination - use this
 * in file
 * 3
 * 1 1 2 9
 * 2 4 -3 1
 * 3 6 -5 0
 * https://www.youtube.com/watch?v=AhUyh-2aPEc
 */

public class Stage3 {
    private static String inFile;
    private static String outFile;

    public static void main(String[] args) {
        readArgs(args);
        double[][] matrix = readFile(inFile);
        if (matrix != null) {
            System.out.println("Initial matrix");
            printCurrent(matrix);
            System.out.println("== Go down");
            for (int i = 0; i < matrix.length; i++) {
                System.out.println("Make 1 and zero below i = " + i);
                makeOneOfVar(matrix, i);
                zeroBelow(matrix, i);
                printCurrent(matrix);
            }
            System.out.println("== Go up");
            for (int i = matrix.length - 1; i > 0; i--) {
                System.out.println("Make zero above i = " + i);
                zeroAbove(matrix, i);
                printCurrent(matrix);
            }
            saveToFile(matrix);
        }
    }

    /**
     * Save results to fie
     *
     * @param matrix - we need only last col
     */
    private static void saveToFile(double[][] matrix) {
        File file = new File(outFile);
        try (PrintWriter printWriter = new PrintWriter(file)) {
            for (double[] doubles : matrix) {
                printWriter.println(doubles[matrix[0].length - 1]);
            }
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }

    /**
     * Make 0 to x'th column direction above
     *
     * @param matrix - matrix
     * @param x      - col
     */
    private static void zeroAbove(double[][] matrix, int x) {
        for (int i = x - 1; i >= 0; i--) {
            double coef = matrix[i][x];
            for (int j = 0; j < matrix[0].length; j++) {
                // -coef * R(x) + R(j) -> new R(j)
                matrix[i][j] = matrix[i][j] - coef * matrix[x][j];
            }
        }
    }

    /**
     * Make 0 to x'th column
     *
     * @param matrix - matrix
     * @param x      - col
     */
    private static void zeroBelow(double[][] matrix, int x) {
        for (int i = x + 1; i < matrix.length; i++) {
            double coef = matrix[i][x];
            for (int j = 0; j < matrix[0].length; j++) {
                // -coef * R(x) + R(j) -> new R(j)
                matrix[i][j] = matrix[i][j] - coef * matrix[x][j];
            }
        }
    }

    /**
     * Do x(i) == 1
     *
     * @param matrix - init matrix
     * @param x      - i
     */
    private static void makeOneOfVar(double[][] matrix, int x) {
        double coef = matrix[x][x];
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[x][i] = matrix[x][i] / coef;
        }
    }

    /**
     * Read file
     *
     * @param inFile - input file
     */
    private static double[][] readFile(String inFile) {

        File file = new File(inFile);

        try (Scanner scanner = new Scanner(file)) {
            String s = scanner.nextLine();
            int n = Integer.parseInt(s);
            double[][] matrix = new double[n][n + 1];
            String current;
            int row = 0;
            while (scanner.hasNextInt()) {
                current = scanner.nextLine();
                String[] sp = current.split(" ");
                for (int i = 0; i < sp.length; i++) {
                    matrix[row][i] = Double.parseDouble(sp[i]);
                }
                row++;
            }
            return matrix;
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + inFile);
        }
        return null;
    }


    /**
     * Read in and out file names
     *
     * @param args - java Solver -in in.txt -out out.txt
     */
    private static void readArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-in":
                    inFile = args[i + 1];
                    break;
                case "-out":
                    outFile = args[i + 1];
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Print coef + right part
     *
     * @param matrix - matrix to print
     */
    private static void printCurrent(double[][] matrix) {
        for (double[] doubles : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%3f ", doubles[j]);
            }
            System.out.println();
        }
    }
}
