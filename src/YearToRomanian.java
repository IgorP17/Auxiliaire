public class YearToRomanian {

    public static void main(String[] args) {
        System.out.println(solution(1666));
    }

    public static String solution(int n) {
        StringBuilder roman = new StringBuilder();
        int number = n;
        while (number >= 1000) {
            // Move 1000 from N to roman.
            roman.append("M");
            number -= 1000;
        }
        // 900
        while (number >= 900) {
            // Move 900 from N to roman.
            roman.append("CM");
            number -= 900;
        }
        // 500
        while (number >= 500) {
            roman.append("D");
            number -= 500;
        }
        // 400
        while (number >= 400) {
            roman.append("CD");
            number -= 400;
        }
        // 100
        while (number >= 100) {
            roman.append("C");
            number -= 100;
        }
        // 90
        while (number >= 90) {
            roman.append("XC");
            number -= 90;
        }
        // 50
        while (number >= 50) {
            roman.append("L");
            number -= 50;
        }
        // 40
        while (number >= 40) {
            roman.append("XL");
            number -= 40;
        }
        // 10
        while (number >= 10) {
            roman.append("X");
            number -= 10;
        }
        // 9
        while (number >= 9) {
            roman.append("IX");
            number -= 9;
        }
        // 5
        while (number >= 5) {
            roman.append("V");
            number -= 5;
        }
        // 4
        while (number >= 4) {
            roman.append("IV");
            number -= 4;
        }
        // 1
        while (number >= 1) {
            roman.append("I");
            number -= 1;
        }

        return roman.toString();
    }
}
