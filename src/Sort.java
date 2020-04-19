import java.util.Scanner;

public class Sort {

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                /* if a pair of adjacent elements has the wrong order it swaps them */
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }

    public static int bubbleSortCount(int[] array) {
        int swaps = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                /* if a pair of adjacent elements has the wrong order it swaps them */
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swaps++;
                }
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] in = scanner.nextLine().split(" ");
        int[] massive = new int[in.length];
        for (int i = 0; i < massive.length; i++) {
            massive[i] = Integer.parseInt(in[i]);
        }
        System.out.println(bubbleSortCount(massive));
    }

}
