package hyperskill.numeralsystemconverter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int radix = Integer.parseInt(scanner.nextLine());
            String in = scanner.nextLine();
            int destRadix = Integer.parseInt(scanner.nextLine());
            String result;
            if (in.contains(".")) {
                String[] parts = in.split("\\.");
                result = getIntPart(radix, parts[0], destRadix);
                result = result + "." + getFractonPart(radix, parts[1], destRadix);
            } else {
                result = getIntPart(radix, in, destRadix);
            }
            //
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }


    /**
     * Get value in base1 and out in in base2 for fraction part
     *
     * @param radix     base1
     * @param in        string (fraction part)
     * @param destRadix base2
     * @return String, value converted from base1 to base2
     */
    private static String getFractonPart(int radix, String in, int destRadix) {
        // convert to base 10...
        double d = 0;
        String s;
        if (radix != 10) {
            for (int i = 0; i < in.length(); i++) {
                s = in.substring(i, i + 1);
                s = getIntPart(radix, s, 10);
                d = d + (Double.parseDouble(s) / Math.pow(radix, (i + 1)));
            }
        } else {
            d = Double.parseDouble("0." + in);
        }

        // convert to dest
        String current;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            d = d * destRadix;
            current = String.valueOf((int) d);
            d = d - (int) d;
//            System.out.printf("Current to add = %s, d = %f\r\n", current, d);
            // NEED convert base10 -> dest base

            result.append(getIntPart(10, current, destRadix));
        }
        return result.toString();
    }

    /**
     * Get value in base1 and out in in base2
     *
     * @param radix     base1
     * @param in        value string (int part)
     * @param destRadix dest
     * @return String, value converted from base1 to base2
     */
    private static String getIntPart(int radix, String in, int destRadix) {
        if (radix < (Character.MIN_RADIX - 1) || destRadix < (Character.MIN_RADIX - 1)
                || radix > Character.MAX_RADIX || destRadix > Character.MAX_RADIX) {
            throw new RuntimeException("ERROR");
        }

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
