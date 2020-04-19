package hyperskill.budgetmanager;

import java.io.*;
import java.util.*;

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
            System.out.println("Choose your action:");
            System.out.println("1) Add income");
            System.out.println("2) Add purchase");
            System.out.println("3) Show list of purchases");
            System.out.println("4) Balance");
            System.out.println("5) Save");
            System.out.println("6) Load");
            System.out.println("7) Analyze (Sort)");
            System.out.println("0) Exit");
            choise = getIn();
            switch (choise) {
                case "0":
                    System.out.println("Bye!");
                    isExit = true;
                    break;
                case "1":
                    System.out.println("Enter income:");
                    totalCents = totalCents + Integer.parseInt(getIn() + "00");
                    System.out.println("Income was added!");
                    break;
                case "2":
                    addPurchase();
                    break;
                case "3":
                    printPurchases();
                    break;
                case "4":
                    System.out.println("Balance: $" + Purchase.convertCentsToDollars(totalCents));
                    System.out.println();
                    break;
                case "5":
                    SaveLoad.save(purchases, String.valueOf(totalCents));
                    break;
                case "6":
                    totalCents = SaveLoad.loadBalance();
                    purchases = SaveLoad.load();
                    System.out.println();
                    break;
                case "7":
                    System.out.println();
                    analyze();
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
        if (purchases.size() == 0) {
            System.out.println("Purchase list is empty!");
        } else {
            while (true) {
                System.out.println("Choose the type of purchases");
                System.out.println("1) Food");
                System.out.println("2) Clothes");
                System.out.println("3) Entertainment");
                System.out.println("4) Other");
                System.out.println("5) All");
                System.out.println("6) Back");

                Category category = Category.ALL;
                String typeInt = scanner.nextLine();
                switch (typeInt) {
                    case "1":
                        category = Category.FOOD;
                        break;
                    case "2":
                        category = Category.CLOTHES;
                        break;
                    case "3":
                        category = Category.ENTERTAINMENT;
                        break;
                    case "4":
                        category = Category.OTHER;
                        break;
                    case "5":
                        break;
                    case "6":
                        return;
                }
                System.out.println();
                System.out.println(category.getName() + ":");
                printList(purchases, category);
            }


        }
    }

    private void analyze() {
        while (true) {
            System.out.println("How do you want to sort?");
            System.out.println("1) Sort all purchases");
            System.out.println("2) Sort by type");
            System.out.println("3) Sort certain type");
            System.out.println("4) Back");
            String in = scanner.nextLine();
            if ("4".equalsIgnoreCase(in)){
                return;
            }
            if (purchases.size() == 0) {
                System.out.println("Purchase list is empty!");
            } else {
                switch (in) {
                    case "1":
                        ArrayList<Purchase> ps = new ArrayList<>(purchases);
                        ps.sort(Comparator.comparing(Purchase::getAmount));
                        // sort desc
                        Collections.reverse(ps);
                        System.out.println();
                        System.out.println("All:");
                        printList(ps, Category.ALL);
                        break;
                    case "2":
                        System.out.println();
                        System.out.println("Types:");
                        printCategoryList();
                        break;
                    case "3":
                        System.out.println();
                        System.out.println("Choose the type of purchase");
                        System.out.println("1) Food");
                        System.out.println("2) Clothes");
                        System.out.println("3) Entertainment");
                        System.out.println("4) Other");
                        String cat = scanner.nextLine();
                        Category category = Category.ALL;
                        switch (cat) {
                            case "1":
                                category = Category.FOOD;
                                break;
                            case "2":
                                category = Category.CLOTHES;
                                break;
                            case "3":
                                category = Category.ENTERTAINMENT;
                                break;
                            case "4":
                                category = Category.OTHER;
                                break;
                        }
                        ArrayList<Purchase> pur = new ArrayList<>(purchases);
                        pur.sort(Comparator.comparing(Purchase::getAmount));
                        // sort desc
                        Collections.reverse(pur);
                        System.out.println();
                        System.out.println(category.getName() + ":");
                        printList(pur, category);
                        break;
                }
            }
        }

    }

    private void printCategoryList() {
        HashMap<Category, Integer> hashMap = new HashMap<>();
        int totals = 0;
        for (Purchase purchase : purchases) {
            // check if map has key
            if (hashMap.containsKey(purchase.getCategory())) {
                // add cents
                hashMap.put(purchase.getCategory(),
                        hashMap.get(purchase.getCategory()) + purchase.getAmount());
            } else {
                // add key
                hashMap.put(purchase.getCategory(), purchase.getAmount());
            }
            totals = totals + purchase.getAmount();
        }
        // sort
        LinkedHashMap<Category, Integer> result = sortByValue(hashMap);
        // print
        for (Map.Entry<Category, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey().getName() + " - $" + Purchase.convertCentsToDollars(entry.getValue()));
        }
        System.out.println("Total sum: $" + Purchase.convertCentsToDollars(totals));
        System.out.println();
    }

    private void printList(ArrayList<Purchase> ps, Category category) {
        if (ps.size() == 0) {
            System.out.println("Purchase list is empty!");
        } else {
            int totals = 0;
            for (Purchase purchase : ps) {
                if (category == purchase.getCategory() || category == Category.ALL) {
                    System.out.println(purchase.getName()
                            + " $"
                            + Purchase.convertCentsToDollars(purchase.getAmount()));
                    totals = totals + purchase.getAmount();
                }
            }
            System.out.println("Total sum: $" + Purchase.convertCentsToDollars(totals));
        }
        System.out.println();
    }


    /**
     * Sort map
     * https://mkyong.com/java/how-to-sort-a-map-in-java/
     *
     * @param unsortMap unsorted map
     * @return sorted map
     */
    private static LinkedHashMap<Category, Integer> sortByValue(Map<Category, Integer> unsortMap) {

        // 1. Convert Map to List of Map
        List<Map.Entry<Category, Integer>> list =
                new LinkedList<>(unsortMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        // Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
        list.sort(Map.Entry.comparingByValue());

        // reverse
        Collections.reverse(list);

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        LinkedHashMap<Category, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Category, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        /*
        //classic iterator example
        for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }*/


        return sortedMap;
    }

    /**
     * Get in string and do sout
     * @return - input
     */
    private String getIn(){
        String result = scanner.nextLine();
        System.out.println();
        return result;
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
        String cents;
        if (splited.length == 1) {
            cents = "00";
        } else {
            cents = splited[1];
        }
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

    public static String convertCentsToDollars(int cents) {
        String dollars = String.valueOf(cents / 100);
        String cent = String.valueOf(cents % 100);
        if (cent.length() == 1) {
            cent = "0" + cent;
        }
        return dollars + "." + cent;
    }
}

enum Category {

    FOOD("Food"),
    CLOTHES("Clothes"),
    ENTERTAINMENT("Entertainment"),
    OTHER("Other"),
    ALL("All");

    private String name;

    Category(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}

class SaveLoad {
    private final static String file = "purchases.txt";

    static void save(ArrayList<Purchase> purchases, String balance) {
        try (PrintStream out = new PrintStream(new FileOutputStream(file))) {
            out.println(balance);
            for (Purchase purchase : purchases) {
                out.println(purchase.getName());
                out.println(purchase.getAmount());
                out.println(purchase.getCategory());
            }
            System.out.println(System.lineSeparator() + "Purchases were saved!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static ArrayList<Purchase> load() {
        ArrayList<Purchase> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            // skip first line - it is balance
            br.readLine();
            String line;
            line = br.readLine();
            String name;
            String amount;
            String category;

            while (line != null) {
                // if we have smth it is name
                name = line;
                // next should be amount !!! cents
                line = br.readLine();
                amount = line; // cents
                // category
                line = br.readLine();
                category = line;
                result.add(new Purchase(name, Purchase.convertCentsToDollars(Integer.parseInt(amount)), category));
                // try to read next
                line = br.readLine();
            }

            System.out.println("Purchases were loaded!");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


    static int loadBalance() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            if (null == line) {
                throw new RuntimeException("Invalid file!");
            } else {
                return Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}