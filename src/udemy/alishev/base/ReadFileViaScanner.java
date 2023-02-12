package udemy.alishev.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileViaScanner {
    public static void main(String[] args) {
        String path = "./Hands.txt";
        File file = new File(path);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (scanner != null)
                scanner.close();
        }
    }
}
