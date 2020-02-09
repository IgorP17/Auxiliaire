package hyperskill.recognition;

import java.util.Scanner;

public class DigitRecognitionTestSmth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        while (scanner.hasNext()){
            s = scanner.next();
            if ("0".equalsIgnoreCase(s)){
                break;
            }
            try{
                int n = Integer.parseInt(s);
                System.out.println(n * 10);
            } catch (Exception e){
                System.out.println("Invalid user input: " + s);
            }
        }

    }


}

/*  Get massive
    long[] array = Arrays.stream(scanner.nextLine().split(" "))
            .mapToLong(Long::parseLong)
            .toArray();

    Use EN local
    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
 */
