package digit.recognition;

import java.util.Locale;
import java.util.Scanner;

public class DigitRecognitionTestSmth {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    double c = scanner.nextDouble();
    double f = c * 1.8 + 32;
    System.out.println(f);
  }



}

/*  Get massive
    long[] array = Arrays.stream(scanner.nextLine().split(" "))
            .mapToLong(Long::parseLong)
            .toArray();

    Use EN local
    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
 */
