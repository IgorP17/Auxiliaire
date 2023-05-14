package algorithms;

public class AddBinaryStrings {


    public static void main(String[] args) {
        System.out.println("Case 1: " + addBinary("11", "1"));
        System.out.println("Case 2: " + addBinary("1", "10"));
        System.out.println("Case 3: " + addBinary("1", "100"));
        System.out.println("Case 4: " + addBinary("100", "1"));
        System.out.println("Case 5: " + addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));

    }


    // best solutions
    private static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0)
                carry += a.charAt(i--) - '0';
            if (j >= 0)
                carry += b.charAt(j--) - '0';
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }

/*
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        if (a.length() < b.length()) {
            a = String.join("", Collections.nCopies(b.length() - a.length(), "0")) + a;
        } else if (a.length() > b.length()) {
            b = String.join("", Collections.nCopies(a.length() - b.length(), "0")) + b;
        }
        boolean isExceed = false;
        char[] achars = a.toCharArray();
        char[] bchars = b.toCharArray();

        for (int i = achars.length - 1; i >= 0; i--) {
            if (achars[i] == '0' && bchars[i] == '0') {
                if (isExceed) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
                isExceed = false;
            } else if ((achars[i] == '1' && bchars[i] == '0') || (achars[i] == '0' && bchars[i] == '1')) {
                if (isExceed) {
                    sb.append("0");
                } else {
                    sb.append("1");
                }
            } else {
                if (isExceed) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
                isExceed = true;
            }
        }

        if (isExceed)
            sb.append("1");
        return sb.reverse().toString();
    }
*/
}
