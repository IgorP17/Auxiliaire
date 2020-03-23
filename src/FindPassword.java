import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        // My email javacoder@gmail.com with password    SECRET115. Here is my old PASSWORD: PASS111.
        Pattern pattern = Pattern.compile("((?<=password:?)\\s*\\w+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        boolean isFound = false;
        while (matcher.find()) {
            isFound = true;
            System.out.println(matcher.group().trim());
        }
        if (!isFound){
            System.out.println("No passwords found.");
        }
    }
}
