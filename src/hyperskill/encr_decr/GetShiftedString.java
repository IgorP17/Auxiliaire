package hyperskill.encr_decr;

import java.util.Scanner;

/**
 * Goal
 * Write a program that reads an English message and an integer number (key)
 * from the standard input and shifts each letter by the specified number
 * according to its order in the alphabet.
 * If you reach the end of the alphabet,
 * start back at the beginning (a follows z).
 * The English alphabet is below:
 * <p>
 * abcdefghijklmnopqrstuvwxyz
 * <p>
 * The program should not modify non-letter characters.
 */

public class GetShiftedString {


    public static void main(String[] args) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        int shift = scanner.nextInt();
        // get abs shift
        // TODO Negative shift?
        shift = shift % 26;
        int pos;
        StringBuilder res = new StringBuilder();
        for (char ch : message.toCharArray()) {
            pos = alphabet.indexOf(ch);
            if (pos == -1) {
                res.append(ch);
            } else {
                int currentPos = (pos + shift) % 26;
                res.append(alphabet.charAt(currentPos));
            }
        }
        System.out.println(res);
    }

}
