package hyperskill.numeralsystemconverter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int radix = Integer.parseInt(scanner.nextLine());
        String in = scanner.nextLine();
        int destRadix = Integer.parseInt(scanner.nextLine());
        String[] parts = in.split("\\.");
        if (parts.length != 2){
            System.out.println("FUCK");
            System.exit(1);
        }
        String result = getIntPart(radix, parts[0], destRadix);

        System.out.println(result);
    }

    /**
     * Get value in base1 and out in in base2
     * @param radix base1
     * @param in value string (int part)
     * @param destRadix dest
     * @return String, value converted from base1 to base2
     */
    private static String getIntPart(int radix, String in, int destRadix){
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
            return s;
        } else {
            return Long.toString(x, destRadix);
        }
    }

}
