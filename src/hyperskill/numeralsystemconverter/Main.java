package hyperskill.numeralsystemconverter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int radix = Integer.parseInt(scanner.nextLine());
        String in = scanner.nextLine();
        int destRadix = Integer.parseInt(scanner.nextLine());
        long x;
        if (radix != 1) {
            // radix = основание
            x = Long.parseLong(in, radix);
        } else {
            // if radix == 1 then repeat by len
            x = in.length();
        }

        if (destRadix == 1) {
            String s = "1";
            s = s.repeat(Integer.parseInt(in));
            System.out.println(s);
        } else {
            System.out.println(Long.toString(x, destRadix));
        }
    }

}
