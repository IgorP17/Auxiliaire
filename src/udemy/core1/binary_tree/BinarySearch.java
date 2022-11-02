package udemy.core1.binary_tree;

public class BinarySearch {

    // Технически есть уже реализации
    // Arrays.binarySearch()
    // Collections.binarySearch()

    static int steps;

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        steps = 0;
        System.out.println("=== Searching 10");
        System.out.println("Index of 10 = " + binarySearchRecursively(array, 10, 0, array.length));
        steps = 0;
        System.out.println("=== Searching 1");
        System.out.println("Index of 1 = " + binarySearchRecursively(array, 1, 0, array.length));
        steps = 0;
        System.out.println("=== Searching 20");
        System.out.println("Index of 20 = " + binarySearchRecursively(array, 20, 0, array.length));
        steps = 0;
        System.out.println("=== Searching 11");
        System.out.println("Index of 11 = " + binarySearchRecursively(array, 11, 0, array.length));

    }

    /**
     * бинарный поиск через рекурсию
     * !!! массив должен быть отсортирован
     *
     * @param sortedArray отсортированный массив
     * @param key         что ищем
     * @param low         нижняя граница
     * @param high        верхняя граница
     * @return индекс ключа в массиве(если нашли), иначе -1
     */
    public static int binarySearchRecursively(int[] sortedArray, int key, int low, int high) {
        // вычисляем середину
        int middle = low + ((high - low) / 2);

        if (high < low) {
            return -1;
        }

        // если на середине наше - то вернем
        if (key == sortedArray[middle]) {
            System.out.println("=== Found " + key + " in " + steps + " steps");
            return middle;
        } else if (key < sortedArray[middle]) {
            // если на середине не наше и при этом искомое меньше середины,
            // то вызываем себя же с границей минимума и середина - 1, ибо элемент там
            steps++;
            System.out.println("Search range is " + low + ":" + (middle - 1) + ", step " + steps
                    + ", middle was = " + middle);
            return binarySearchRecursively(
                    sortedArray, key, low, middle - 1);
        } else {
            // если на середине не наше и при этом искомое больше середины,
            // то вызываем себя же с границей середина + 1 и максимум индекса массива, ибо элемент там
            steps++;
            System.out.println("Search range is " + (middle + 1) + ":" + high + ", step " + steps
                    + ", middle was = " + middle);
            return binarySearchRecursively(
                    sortedArray, key, middle + 1, high);
        }
    }


    /*
    public int runBinarySearchIteratively(
            int[] sortedArray, int key, int low, int high) {
        int index = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }*/
}
