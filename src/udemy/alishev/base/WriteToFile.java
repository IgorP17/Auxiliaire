package udemy.alishev.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteToFile {
    public static void main(String[] args) {
        File file = new File("test.txt");
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(file);
            printWriter.println("Test row 1");
            printWriter.println("Test row 2");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }


    }
}
