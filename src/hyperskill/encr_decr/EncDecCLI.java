package hyperskill.encr_decr;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class EncDecCLI {

    private static String method = "enc";
    private static String fileIn;
    private static String fileOut;
    private static String message = "";
    private static String alg = "shift";
    private static int shift = 0;

    public static void main(String[] args) {
        readParams(args);
        // in
        if (fileIn != null) {
            message = readFile();
        }

        // out
        if (fileOut == null) {
            if ("unicode".equalsIgnoreCase(alg)) {
                System.out.println(sEncOrDecUnicode(message, shift, method));
            } else {
                System.out.println(sEncOrDec(message, shift, method));
            }
        } else {
            if ("unicode".equalsIgnoreCase(alg)) {
                writeFile(sEncOrDecUnicode(message, shift, method));
            } else {
                writeFile(sEncOrDec(message, shift, method));
            }
        }
    }


    private static String sEncOrDec(String s, int shift, String method) {
        // a-z - 97-122
        // A-Z - 65-90
        boolean isLetter;
        boolean isLowerCase;
        char resChar;
        StringBuilder res = new StringBuilder();
        // shift
        shift = shift % 26;
        if ("dec".equalsIgnoreCase(method)) {
            shift = -shift;
        }
        for (Character ch : s.toCharArray()) {
            isLetter = (ch >= 97 && ch <= 122) || (ch >= 65 && ch <= 90);
            if (isLetter) {
                // get upper lower
                isLowerCase = ch >= 97;
                // do shift
                resChar = (char) (ch + shift);
                // check bounds
                if (isLowerCase) {
                    if (resChar > 122) {
                        resChar = (char) (resChar - 26);
                    } else if (resChar < 97) {
                        resChar = (char) (resChar + 26);
                    }
                } else {
                    if (resChar > 90) {
                        resChar = (char) (resChar - 26);
                    } else if (resChar < 65) {
                        resChar = (char) (resChar + 26);
                    }
                }
                res.append(resChar);
            } else {
                res.append(ch);
            }

        }
//        System.out.println('a' + 0);
//        System.out.println('z' + 0);
//        System.out.println('A' + 0);
//        System.out.println('Z' + 0);
        return res.toString();
    }

    private static String sEncOrDecUnicode(String s, int shift, String method) {
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
            if ("-in".equalsIgnoreCase(s[i])) {
                fileIn = s[i + 1];
            }
            if ("-out".equalsIgnoreCase(s[i])) {
                fileOut = s[i + 1];
            }
            if ("-alg".equalsIgnoreCase(s[i])) {
                alg = s[i + 1];
            }
        }
    }

    private static String readFile() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileIn))) {
            String line = null;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private static void writeFile(String message) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileOut), StandardCharsets.UTF_8))) {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
