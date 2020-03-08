package hyperskill.simplesearchengine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Peoples peoples = new Peoples(args);
        peoples.run();
    }


}

/**
 * Peoples class
 */
class Peoples {
    private static final String separator = System.lineSeparator();
    private ArrayList<People> peoples = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private String[] args;

    Peoples(String[] args){
        this.args = args;
    }

    /**
     * Main cycle
     */
    void run() {
        fillPeoples();
        boolean isTimeToContinue = true;
        String choice;
        while (isTimeToContinue) {
            System.out.println(separator + "=== Menu ===");
            System.out.println("1. Find a person");
            System.out.println("2. Print all people");
            System.out.println("0. Exit");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    findPeoples();
                    break;
                case "2":
                    printAllPeoples();
                    break;
                case "0":
                    isTimeToContinue = false;
                    System.out.println(separator + "Bye!");
                    break;
                default:
                    System.out.println(separator + "Incorrect option! Try again.");
                    break;
            }

        }
    }

    /**
     * Print peoples
     */
    private void printAllPeoples() {
        System.out.println(separator + "=== List of people ===");
        for (People p : peoples) {
            System.out.println(p);
        }
    }

    /**
     * Find peoples
     */
    private void findPeoples() {
        String search;
        System.out.println(separator + "Enter a name or email to search all suitable people.");
        search = scanner.nextLine();
        ArrayList<People> found = findPeople(peoples, search);
        if (found.isEmpty()) {
            System.out.println(separator + "No matching people found.");
        } else {
            for (People p : found) {
                System.out.println(p);
            }
        }
    }

    /**
     * Fill peoples
     */
    private void fillPeoples() {
        // --data data.txt
        for (int i = 0; i < args.length; i++) {
            if ("--data".equalsIgnoreCase(args[i])){
                // check if have filename
                if (( i + 1) < args.length){
                    // read file
                    try (BufferedReader br = new BufferedReader(new FileReader(args[i + 1]))) {
                        String line = br.readLine();
                        while (line != null) {
                            peoples.add(People.parce(line.split(" ")));
                            line = br.readLine();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * Search peoples
     *
     * @param people - list of peoples
     * @param find   - what will be searching
     * @return - list of founded peoples
     */
    private ArrayList<People> findPeople(ArrayList<People> people, String find) {
        ArrayList<People> result = new ArrayList<>();
        for (People p : people) {
            if (p.isContains(find)) {
                result.add(p);
            }
        }
        return result;
    }
}

/**
 * Single people class
 */
class People {
    private String firstName;
    private String secondName;
    private String email;

    /**
     * Constructor
     *
     * @param firstName  - first name
     * @param secondName - second name
     * @param email      - email
     */
    People(String firstName, String secondName, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
    }

    /**
     * Parse [] to people
     *
     * @param s - massive of strings
     * @return - People object
     */
    static People parce(String[] s) {
        if (null == s || s.length == 0) {
            return new People(null, null, null);
        } else {
            if (s.length == 3) {
                return new People(s[0], s[1], s[2]);
            } else if (s.length == 2) {
                return new People(s[0], s[1], null);
            } else {
                return new People(s[0], null, null);
            }
        }

    }

    /**
     * If any field equals
     *
     * @param s - search string
     * @return - if any equals
     */
    boolean isContains(String s) {
        s = s.toLowerCase().trim();
        return (firstName.toLowerCase().contains(s) ||
                (null != secondName && secondName.toLowerCase().contains(s)) ||
                (null != email && email.toLowerCase().contains(s)));
    }

    @Override
    /*public String toString() {
        return "People{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }*/
    public String toString() {
        return firstName + (null == secondName ? " " : " " + secondName) + (null == email ? "" : " " + email);
    }
}


