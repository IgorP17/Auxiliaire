package hyperskill.recognition;

import java.util.Scanner;

public class Sample {
  private static int[] input = new int[9];
  private static int[] w = new int[]{2, 1, 2, 4, -4, 4, 2, -1, 2};

  public static void main(String[] args) {
    readInput();
    int b = -5;
    int result = (input[0] * w[0])
            + (input[1] * w[1])
            + (input[2] * w[2])
            + (input[3] * w[3])
            + (input[4] * w[4])
            + (input[5] * w[5])
            + (input[6] * w[6])
            + (input[7] * w[7])
            + (input[8] * w[8])
            + (b);
    if (result > 0){
      System.out.println("This number is 0");
    } else {
      System.out.println("This number is 1");
    }
  }

  private static void readInput() {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    input[0] = getInput(s.charAt(0));
    input[1] = getInput(s.charAt(1));
    input[2] = getInput(s.charAt(2));
    s = scanner.nextLine();
    input[3] = getInput(s.charAt(0));
    input[4] = getInput(s.charAt(1));
    input[5] = getInput(s.charAt(2));
    s = scanner.nextLine();
    input[6] = getInput(s.charAt(0));
    input[7] = getInput(s.charAt(1));
    input[8] = getInput(s.charAt(2));
  }

  private static int getInput(char ch) {
    if ('X' == ch) {
      return 1;
    }
    return 0;
  }
}
