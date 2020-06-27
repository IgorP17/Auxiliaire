import java.util.Stack;

/**
 * Найти в треугольнике путь с максимальной суммой
 * Спускаемся вниз, нижний элемент либо = idx или idx + 1
 */

public class TriangleDP {
    public static void main(String[] args) {
        int[][] test = new int[][]{{75},
                {95, 64},
                {17, 47, 82},
                {18, 35, 87, 10},
                {20, 4, 82, 47, 65},
                {19, 1, 23, 75, 3, 34},
                {88, 2, 77, 73, 7, 63, 67},
                {99, 65, 4, 28, 6, 16, 70, 92},
                {41, 41, 26, 56, 83, 40, 80, 70, 33},
                {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
                {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
                {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
                {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
                {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
                {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23},
        };

        System.out.println(longestSlideDown(test));
    }

    public static int longestSlideDown(int[][] pyramid) {
        // необходимо привести к матрице, обычной, 0
        int[][] matrix = new int[pyramid.length][pyramid[pyramid.length - 1].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j >= pyramid[i].length) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = pyramid[i][j];
                }
            }
        }

        /* наша задача выглядит как путь с минимальными затратами (?)
           идем с пред последней строки
           для каждого элемента проверяем элемент ниже и правее
           и добавляем максимум из них к нему
        */

        for (int i = matrix.length - 1 - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (matrix[i + 1][j] > matrix[i + 1][j + 1]) {
                    matrix[i][j] = matrix[i][j] + matrix[i + 1][j];
                } else {
                    matrix[i][j] = matrix[i][j] + matrix[i + 1][j + 1];
                }
            }
        }

        // В результате на верху поимеем максимум
        return matrix[0][0];
    }
}
