package hyperskill.budgetmanager;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /*
    To end the input, the user should type End-of-file symbol that tells your operating system that
     no more input will be provided. It's Ctrl+D on Linux and Mac and Ctrl+Z on Windows.
     */
    public static void main(String[] args) {
        Budget budget = new Budget();
        budget.run();

    }

}

class Budget {
    private ArrayList<Purchase> purchases = new ArrayList<>();
    private int totalCents = 0;
    private Scanner scanner = new Scanner(System.in);

    void run() {
        // show menu
        boolean isExit = false;
        String choise;
        while (!isExit) {
            System.out.println();
            System.out.println("Choose your action:");
            System.out.println("1) Add income");
            System.out.println("2) Add purchase");
            System.out.println("3) Show list of purchases");
            System.out.println("4) Balance");
            System.out.println("0) Exit");
            choise = scanner.nextLine();
            switch (choise) {
                case "0":
                    System.out.println();
                    System.out.println("Bye!");
                    isExit = true;
                    break;
                case "1":
                    System.out.println();
                    System.out.println("Enter income:");
                    totalCents = totalCents + Integer.parseInt(scanner.nextLine() + "00");
                    System.out.println("Income was added!");
                    break;
                case "2":
                    addPurchase();
                    break;
                case "3":
                    printPurchases();
                    break;
                case "4":
                    System.out.println();
                    System.out.println("Balance: $" + convertCentsToDollars(totalCents));
                    break;
                default:
                    System.out.println("Unknown option");
            }

        }
    }

    /**
     * Add Purchase
     * Add and switch on input
     */
    private void addPurchase() {
        while (true) {
            System.out.println();
            System.out.println("Choose the type of purchase");
            System.out.println("1) Food");
            System.out.println("2) Clothes");
            System.out.println("3) Entertainment");
            System.out.println("4) Other");
            System.out.println("5) Back");

            String typeInt = scanner.nextLine();
            String type;

            switch (typeInt) {
                case "1":
                    type = "Food";
                    break;
                case "2":
                    type = "Clothes";
                    break;
                case "3":
                    type = "Entertainment";
                    break;
                case "4":
                    type = "Other";
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid type!");
                    return;
            }

            System.out.println();
            System.out.println("Enter purchase name:");
            String name = scanner.nextLine();
            System.out.println("Enter its price:");
            String amount = scanner.nextLine();


            Purchase purchase = new Purchase(name, amount, type);
            purchases.add(purchase);
            totalCents = totalCents - purchase.getAmount();
            System.out.println("Purchase was added!");
        }

    }


    private void printPurchases() {
        System.out.println();
        int totals = 0;
        if (purchases.size() == 0) {
            System.out.println("Purchase list is empty!");
        } else {
            for (Purchase purchase : purchases) {
                System.out.println(purchase.getName()
                        + " $"
                        + convertCentsToDollars(purchase.getAmount()));
                totals = totals + purchase.getAmount();

            }
            System.out.println("Total sum: $" + convertCentsToDollars(totals));
        }
    }

    private String convertCentsToDollars(int cents) {
        String dollars = String.valueOf(cents / 100);
        String cent = String.valueOf(cents % 100);
        if (cent.length() == 1) {
            cent = "0" + cent;
        }
        return dollars + "." + cent;
    }
}


class Purchase {
    private String name;
    private int amount; // cents
    private Category category;

    public Purchase(String name, String amount, String category) {
        this.name = name;

        String[] splited = amount.split("\\.");
        String dollars = splited[0];
        String cents = splited[1];
        if (cents.length() == 1) {
            cents = cents + "0";
        }
        this.amount = Integer.parseInt(dollars + cents);

        switch (category.toLowerCase()) {
            case "food":
                this.category = Category.FOOD;
                break;
            case "clothes":
                this.category = Category.CLOTHES;
                break;
            case "entertainment":
                this.category = Category.ENTERTAINMENT;
                break;
            default:
                this.category = Category.OTHER;
                break;
        }
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public Category getCategory() {
        return category;
    }
}

enum Category {

    FOOD("Food"), CLOTHES("Clothes"), ENTERTAINMENT("Entertainment"), OTHER("Other");

    private String name;

    Category(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
