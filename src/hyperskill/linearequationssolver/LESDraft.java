package hyperskill.linearequationssolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LESDraft {

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        File file = new File("data.txt");
        int counter = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                int current = scanner.nextInt();
                if (current == 0){
                    break;
                }
                if (current % 2 == 0){
                    counter++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + "data.txt");
        }
        System.out.println(counter);
    }
}


/*
===READ FILE
File file = new File(pathToFile);

try (Scanner scanner = new Scanner(file)) {
    while (scanner.hasNextInt()) {
        System.out.print(scanner.nextInt() + " ");
    }
} catch (FileNotFoundException e) {
    System.out.println("No file found: " + pathToFile);
}

public static String readFileAsString(String fileName) throws IOException {
    return new String(Files.readAllBytes(Paths.get(fileName)));
}

===WRITE FILE
File file = new File("/home/username/path/to/your/file.txt");

try (FileWriter writer = new FileWriter(file)) {
    writer.write("Hello, World");
} catch (IOException e) {
    System.out.printf("An exception occurs %s", e.getMessage());
}

File file = new File("/home/art/Documents/file.txt");
try (PrintWriter printWriter = new PrintWriter(file)) {
    printWriter.print("string1"); // prints a string
    printWriter.println("string2"); // prints a string and then terminates the line
    printWriter.println(123); // prints a number
    printWriter.printf("You have %d %s", 400, "golds"); // prints a formatted string
} catch (IOException e) {
    System.out.printf("An exception occurs %s", e.getMessage());
}

 */
