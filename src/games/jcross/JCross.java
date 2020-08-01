package games.jcross;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JCross {

    private final static String eof = System.lineSeparator();
    private final static String eq = "=".repeat(5);

    private static final Scanner scanner = new Scanner(System.in);

    private static int rows;
    private static int cols;

    public static void main(String[] args) {

        boolean isFileLoaded = false;

        while (true){
            System.out.printf("%s%s Main menu %s%s", eof, eq, eq, eof);
            System.out.println("0. Exit");
            System.out.println("1. Load 5x5 Zorro");

            String choice = scanner.nextLine();
            switch (choice){
                case "0":
                    System.out.printf("%1$sBye!", eof);
                    System.exit(0);
                case "1":
                    isFileLoaded = loadFromFile("zorro.txt");
                    break;
                default:
                    System.out.printf("%1$sInvalid input%1$s", eof);
                    break;
            }
            if (isFileLoaded){
                System.out.printf("%1$sFile loaded%1$s", eof);
            } else {
                System.out.printf("%1$sFile NOT loaded%1$s", eof);
            }
        }
    }

    private static boolean loadFromFile(String fileName){
        String file = "./src/games/jcross/" + fileName;
        // read file
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while((line = br.readLine()) != null){
                if (line.startsWith("size")){
                    // got size
                    rows = Integer.parseInt(line.split(":")[1].split("x")[0]);
                    cols = Integer.parseInt(line.split(":")[1].split("x")[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }


}
