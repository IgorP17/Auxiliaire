package digit.recognition;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class DigitRecognitionTestSmth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        Random random = new Random();
        random.setSeed(a + b);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += random.nextInt(b - a + 1) + a;
        }
        System.out.println(sum);
    }


}

/*  Get massive
    long[] array = Arrays.stream(scanner.nextLine().split(" "))
            .mapToLong(Long::parseLong)
            .toArray();

    Use EN local
    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
 */
