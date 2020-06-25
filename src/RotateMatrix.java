/**
 * Given an n x n array, return the array elements arranged from outermost elements to the middle element,
 * traveling clockwise.
 *
 * for example
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * should produce
 *
 * 1 2 3 6 9 8 7 4 5
 *
 */

public class RotateMatrix {

    public static void main(String[] args) {
        int[][] array
                = {{1, 2, 3, 1},
                {4, 5, 6, 4},
                {7, 8, 9, 7,},
                {7, 8, 9, 7}};
        int[] result = snail(array);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }
    }

    public static int[] snail(int[][] array) {
        int[] result = new int[array.length * array[0].length];
        int[][] copy = array.clone();

        int pos = 0;

        do {
            // first row to result
            for (int i = 0; i < copy[0].length; i++) {
                result[pos] = copy[0][i];
                pos++;
            }
            // break for len = 1
            if (copy.length == 1) {
                break;
            }
            // eliminate 1st row
            int[][] tmp = new int[copy.length - 1][copy[0].length];
            for (int i = 0; i < tmp.length; i++) {
                for (int j = 0; j < tmp[0].length; j++) {
                    tmp[i][j] = copy[i + 1][j];
                }
            }
            copy = tmp.clone();

//            System.out.println("===");
//            printMatrix(rotateMatrixBy90DegreeCounterClockwise(copy));
//            System.out.println("===");

            copy = rotateMatrixBy90DegreeCounterClockwise(copy);
        } while (copy.length != 0);

        return result;
    }

    //

    //Rotate Matrix to 90 degree toward Right(clockwise)
    private static int[][] rotateMatrixBy90DegreeClockwise(int[][] matrix) {

        int totalRowsOfRotatedMatrix = matrix[0].length; //Total columns of Original Matrix
        int totalColsOfRotatedMatrix = matrix.length; //Total rows of Original Matrix

        int[][] rotatedMatrix = new int[totalRowsOfRotatedMatrix][totalColsOfRotatedMatrix];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                rotatedMatrix[j][(totalColsOfRotatedMatrix - 1) - i] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }

    //Rotate Matrix to 90 degree toward Left(counter clockwise)
    private static int[][] rotateMatrixBy90DegreeCounterClockwise(int[][] matrix) {

        int totalRowsOfRotatedMatrix = matrix[0].length; //Total columns of Original Matrix
        int totalColsOfRotatedMatrix = matrix.length; //Total rows of Original Matrix

        int[][] rotatedMatrix = new int[totalRowsOfRotatedMatrix][totalColsOfRotatedMatrix];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                rotatedMatrix[(totalRowsOfRotatedMatrix - 1) - j][i] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
