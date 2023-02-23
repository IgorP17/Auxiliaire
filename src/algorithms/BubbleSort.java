package algorithms;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[]{5, 4, 3, 2, 1};
        System.out.println("Initial " + Arrays.toString(array));
        array = bubbleSort(array);
        System.out.println("Sorted  " + Arrays.toString(array));
    }

    public static int[] bubbleSort(int[] array) {
        // попарное сравнение элементов, при первом проходе самый тяжелый будет справа
        // всего надо сделать N - 1 раз
        int tmp;
        int[] resultArray = array.clone();
        for (int i = resultArray.length - 1; i >= 1; i--) { // i индекс до которого бежим
            for (int j = 0; j < i; j++) {
                if (resultArray[j] > resultArray[j + 1]) {
                    tmp = resultArray[j];
                    resultArray[j] = resultArray[j + 1];
                    resultArray[j + 1] = tmp;
                }
            }
        }
        return resultArray;
    }
}
