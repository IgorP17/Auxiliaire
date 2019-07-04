package digit.recognition;

import java.util.Scanner;

public class Vowel {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String str = input.nextLine();
    int maxRow = 0;
    boolean wasVowel = false;
    int insert = 0;
    for (char ch : str.toCharArray()) {
      if (wasVowel ^ isVowel(ch)) {
        maxRow = 1;
      } else {
        maxRow++;
        if (maxRow >= 3) {
          insert++;
          maxRow = 1;
        }
      }
      wasVowel = isVowel(ch);
    }
    System.out.println(insert);
  }

  public static boolean isVowel(char c) {
    return "AEIOUYaeiouy".indexOf(c) != -1;
  }
}
