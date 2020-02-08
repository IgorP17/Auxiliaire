package encr_decr;

import java.util.Scanner;

public class StupidEncDec {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String method = scanner.nextLine();
        String message = scanner.nextLine();
        int shift = scanner.nextInt();
        System.out.println(sEncOrDec(message, shift, method));

    }

    private static String sEncOrDec(String s, int shift, String method) {
        StringBuilder res = new StringBuilder();
        if ("dec".equalsIgnoreCase(method)){
            shift = - shift;
        }
        for (char ch : s.toCharArray()){
            ch = (char) (ch + shift);
            res.append(ch);
        }
        return res.toString();
    }


}
