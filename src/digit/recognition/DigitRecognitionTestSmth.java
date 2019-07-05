package digit.recognition;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DigitRecognitionTestSmth {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] array = Arrays.stream(scanner.nextLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
    int[] result = getFirstAndLast(array);
    Arrays.stream(result).forEach(e -> System.out.print(e + " "));
  }

  private static int[] getFirstAndLast(int[] array) {
    return new int[]{array[0], array[array.length - 1]};
  }


}

/*  Get massive
    long[] array = Arrays.stream(scanner.nextLine().split(" "))
            .mapToLong(Long::parseLong)
            .toArray();

    Use EN local
    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
 */
