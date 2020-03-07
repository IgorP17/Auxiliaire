package hyperskill.simplesearchengine;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<People> peoples = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of people:");
        int num = Integer.parseInt(scanner.nextLine());
        String[] s;
        System.out.println("Enter all people:");
        for (int i = 0; i < num; i++) {
            s = scanner.nextLine().split(" ");
            peoples.add(People.parce(s));
        }

        System.out.println("Enter the number of search queries:");
        int tryCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < tryCount; i++) {

        }

    }
}

class People {
    private String firstName;
    private String secondName;
    private String email;

    People(String firstName, String secondName, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
    }

    /**
     * Parse [] to people
     * @param s - massive of strings
     * @return - People object
     */
    static People parce(String[] s) {
        if (null == s || s.length == 0) {
            return new People(null, null, null);
        } else {
            if (s.length == 3){
                return new People(s[0], s[1], s[2]);
            } else if (s.length == 2){
                return new People(s[0], s[1], null);
            } else {
                return new People(s[0], null, null);
            }
        }

    }

    /**
     * If any field equals
     * @param s - search string
     * @return - if any equals
     */
    boolean isContains(String s){
        return (s.equalsIgnoreCase(firstName) ||
                s.equalsIgnoreCase(secondName) ||
                s.equalsIgnoreCase(email));
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


