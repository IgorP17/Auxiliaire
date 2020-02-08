package encr_decr;

public class StupidEncDecCLI {

    private static String method = "enc";
    private static String message = "";
    private static int shift = 0;

    public static void main(String[] args) {
        readParams(args);
        System.out.println(sEncOrDec(message, shift, method));
    }

    private static String sEncOrDec(String s, int shift, String method) {
        StringBuilder res = new StringBuilder();
        if ("dec".equalsIgnoreCase(method)) {
            shift = -shift;
        }
        for (char ch : s.toCharArray()) {
            ch = (char) (ch + shift);
            res.append(ch);
        }
        return res.toString();
    }

    private static void readParams(String[] s) {
        for (int i = 0; i < s.length; i++) {
            if ("-mode".equalsIgnoreCase(s[i])) {
                method = s[i + 1];
            }
            if ("-key".equalsIgnoreCase(s[i])) {
                shift = Integer.parseInt(s[i + 1]);
            }
            if ("-data".equalsIgnoreCase(s[i])) {
                message = s[i + 1];
            }
        }
    }
}
