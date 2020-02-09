package hyperskill.recognition.exception;

import java.util.Arrays;
import java.util.Scanner;

public class Ex {
    public static int[] extractIntNumbersFromString(String s) throws ParsingArrayException {
        try {
            String[] parts = s.split("\\s+");
            int[] numbers = new int[parts.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(parts[i]);
            }

            return numbers;
        } catch (Exception cause) {
            throw new ParsingArrayException(
                    String.format("The string '%s' cannot be parsed as an array of numbers", s),
                    cause // it's a good practice not to lose the original exception
            );
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String line = scanner.nextLine();

            int[] numbers = extractIntNumbersFromString(line);

            System.out.println(Arrays.toString(numbers));
        } catch (ParsingArrayException e) {
            System.out.println(e.getMessage());
        }
    }

}
